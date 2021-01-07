package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.im.message.chat.a;
import com.baidu.tieba.view.i;
import com.baidu.webkit.internal.ETAG;
import java.net.URISyntaxException;
/* loaded from: classes8.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView aia;
    private View dDI;
    private TextView gFk;
    private TbImageView iND;
    private TextView kAA;
    private com.baidu.adp.lib.b.b kwE;
    private ImageView mArrow;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public SingleImageTextView(Context context) {
        this(context, null);
    }

    public SingleImageTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleImageTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kwE = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.aia = (TextView) findViewById(R.id.single_abstract);
        this.iND = (TbImageView) findViewById(R.id.single_content_pic);
        this.iND.setAutoChangeStyle(false);
        this.iND.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.iND.setConrers(15);
        this.kAA = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.dDI = findViewById(R.id.single_divider);
        this.gFk = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.kwE != null) {
                    SingleImageTextView.this.kwE.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0775a c0775a, View view, final int i) {
        if (c0775a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0775a.title)) {
                str = c0775a.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(c0775a.text)) {
                str2 = c0775a.text;
            }
            if (!TextUtils.isEmpty(c0775a.text) && c0775a.text.contains(this.mContext.getResources().getString(R.string.inconformity_forum_rules))) {
                com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(2, c0775a.url) { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(SingleImageTextView.this.mContext, SingleImageTextView.this.MO(c0775a.url), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
                    }

                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
                    }
                };
                int indexOf = c0775a.text.indexOf(this.mContext.getResources().getString(R.string.inconformity_forum_rules));
                SpannableString spannableString = new SpannableString(c0775a.text);
                spannableString.setSpan(fVar, indexOf - 1, indexOf + 6, 33);
                this.aia.setOnTouchListener(new i(spannableString));
                this.aia.setText(spannableString);
                this.kAA.setText(R.string.bar_tie_complain);
            } else {
                this.aia.setText(str2);
            }
            if (!TextUtils.isEmpty(c0775a.url)) {
                if ("com.baidu.tieba://".equals(c0775a.url)) {
                    setEnabled(false);
                } else {
                    setEnabled(true);
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        int i2;
                        if (c0775a != null && c0775a.url != null && c0775a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(c0775a.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        be.bwv().b(tbPageContext, new String[]{c0775a.url});
                        if (c0775a.url != null && c0775a.url.contains("ForumGradePage")) {
                            aq w = new aq("c13783").w("uid", TbadkCoreApplication.getCurrentAccountId());
                            try {
                                Uri parse = Uri.parse(c0775a.url);
                                String queryParameter = parse.getQueryParameter("forum_id");
                                String queryParameter2 = parse.getQueryParameter("obj_type");
                                w.dX("fid", queryParameter);
                                w.dX("obj_type", queryParameter2);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            TiebaStatic.log(w);
                        }
                        if (c0775a.url != null && c0775a.url.contains("weeklygodview")) {
                            TiebaStatic.log(new aq("c13691").w("uid", TbadkCoreApplication.getCurrentAccountId()).an("obj_source", 1));
                        }
                        if (c0775a.url != null && c0775a.url.contains("unidispatch/hotuserrank")) {
                            TiebaStatic.log(new aq("c13665").w("uid", TbadkCoreApplication.getCurrentAccountId()));
                        }
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", c0775a.fid);
                            com.baidu.tieba.im.data.d NC = com.baidu.tieba.im.util.c.NC(c0775a.kyB);
                            if (NC != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", NC.kBb, "task_id", NC.taskId, "loc", "0");
                                if ((c0775a.userType == 1 || c0775a.userType == 3) && !"0".equals(NC.taskId)) {
                                    com.baidu.tieba.im.b.a.cZQ().Nx(NC.taskId);
                                }
                            }
                            aq aqVar = new aq("official_message_open_detail");
                            aqVar.w("msg_id", c0775a.kFM / 100);
                            aqVar.dX("official_id", c0775a.kFN);
                            aqVar.an("official_type", c0775a.kFO);
                            aqVar.w("operate_time", System.currentTimeMillis() / 1000);
                            aqVar.w("task_id", c0775a.taskId);
                            aqVar.dX("obj_params1", c0775a.url);
                            TiebaStatic.log(aqVar);
                        }
                        aq aqVar2 = new aq("c13784");
                        aqVar2.w(Constants.EXTRA_SERVICE, c0775a.serviceId);
                        aqVar2.w("task_id", c0775a.taskId);
                        aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.dX("fid", c0775a.fid);
                        if (!TextUtils.isEmpty(c0775a.title)) {
                            if (!TextUtils.isEmpty(c0775a.url)) {
                                String str3 = null;
                                String[] split = c0775a.url.split("tid=");
                                if (split.length > 1) {
                                    int indexOf2 = split[1].indexOf(ETAG.ITEM_SEPARATOR);
                                    if (indexOf2 != -1) {
                                        str3 = split[1].substring(0, indexOf2);
                                    } else {
                                        str3 = split[1].substring(0);
                                    }
                                }
                                aqVar2.dX("tid", str3);
                            }
                            if (c0775a.title.contains("互动量")) {
                                aqVar2.an("obj_source", 2);
                                aqVar2.an("obj_type", 9);
                            } else if (c0775a.title.contains("被加精")) {
                                aqVar2.an("obj_source", 1);
                                aqVar2.an("obj_type", 9);
                            } else if (c0775a.title.contains("热贴榜")) {
                                aqVar2.an("obj_type", 8);
                            } else if (c0775a.userType == 4) {
                                aqVar2.an("obj_type", 10);
                            } else if (c0775a.userType == 3) {
                                aqVar2.an("obj_type", 5);
                            }
                        }
                        if (c0775a.kFN != null && c0775a.kFN.equals("4754917018")) {
                            aqVar2.delete("obj_type");
                            aqVar2.an("obj_type", 9);
                            if (c0775a.url != null) {
                                if (c0775a.url.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (c0775a.url.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (c0775a.url.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = c0775a.url.contains("type=attention-common") ? 5 : -1;
                                }
                                if (i2 != -1) {
                                    aqVar2.delete("obj_source");
                                    aqVar2.an("obj_source", i2);
                                }
                            }
                        }
                        TiebaStatic.log(aqVar2);
                    }
                });
            }
            if (!TextUtils.isEmpty(c0775a.src)) {
                this.iND.setTag(c0775a.src);
                this.iND.startLoad(c0775a.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.aia.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.aia.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.aia.setText("");
        this.iND.setBackgroundDrawable(null);
        this.iND.setImageDrawable(null);
        this.gFk.setText("");
        this.gFk.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kwE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void sx(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.iND.setAutoChangeStyle(z);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105, 1, skinType);
        ao.setViewTextColor(this.aia, R.color.CAM_X0109, 1, skinType);
        ao.setViewTextColor(this.kAA, R.color.CAM_X0107, 1, skinType);
        SvgManager.bwr().a(this.mArrow, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ao.setViewTextColor(this.gFk, R.color.common_color_10067, 1, skinType);
        ao.setBackgroundResource(this.dDI, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gFk.setVisibility(8);
            this.gFk.setText("");
            return;
        }
        this.gFk.setVisibility(0);
        this.gFk.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String MO(String str) {
        try {
            return Uri.parse(str).getQueryParameter(TbTitleActivityConfig.FORUM_ID);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
