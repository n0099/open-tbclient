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
/* loaded from: classes7.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView ahj;
    private View dyW;
    private TextView gAE;
    private TbImageView iIW;
    private com.baidu.adp.lib.b.b krZ;
    private TextView kvV;
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
        this.krZ = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.ahj = (TextView) findViewById(R.id.single_abstract);
        this.iIW = (TbImageView) findViewById(R.id.single_content_pic);
        this.iIW.setAutoChangeStyle(false);
        this.iIW.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.iIW.setConrers(15);
        this.kvV = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.dyW = findViewById(R.id.single_divider);
        this.gAE = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.krZ != null) {
                    SingleImageTextView.this.krZ.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0758a c0758a, View view, final int i) {
        if (c0758a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0758a.title)) {
                str = c0758a.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(c0758a.text)) {
                str2 = c0758a.text;
            }
            if (!TextUtils.isEmpty(c0758a.text) && c0758a.text.contains(this.mContext.getResources().getString(R.string.inconformity_forum_rules))) {
                com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(2, c0758a.url) { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(SingleImageTextView.this.mContext, SingleImageTextView.this.LG(c0758a.url), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
                    }

                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
                    }
                };
                int indexOf = c0758a.text.indexOf(this.mContext.getResources().getString(R.string.inconformity_forum_rules));
                SpannableString spannableString = new SpannableString(c0758a.text);
                spannableString.setSpan(fVar, indexOf - 1, indexOf + 6, 33);
                this.ahj.setOnTouchListener(new i(spannableString));
                this.ahj.setText(spannableString);
                this.kvV.setText(R.string.bar_tie_complain);
            } else {
                this.ahj.setText(str2);
            }
            if (!TextUtils.isEmpty(c0758a.url)) {
                if ("com.baidu.tieba://".equals(c0758a.url)) {
                    setEnabled(false);
                } else {
                    setEnabled(true);
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        int i2;
                        if (c0758a != null && c0758a.url != null && c0758a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(c0758a.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        be.bsB().b(tbPageContext, new String[]{c0758a.url});
                        if (c0758a.url != null && c0758a.url.contains("ForumGradePage")) {
                            aq w = new aq("c13783").w("uid", TbadkCoreApplication.getCurrentAccountId());
                            try {
                                Uri parse = Uri.parse(c0758a.url);
                                String queryParameter = parse.getQueryParameter("forum_id");
                                String queryParameter2 = parse.getQueryParameter("obj_type");
                                w.dW("fid", queryParameter);
                                w.dW("obj_type", queryParameter2);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            TiebaStatic.log(w);
                        }
                        if (c0758a.url != null && c0758a.url.contains("weeklygodview")) {
                            TiebaStatic.log(new aq("c13691").w("uid", TbadkCoreApplication.getCurrentAccountId()).an("obj_source", 1));
                        }
                        if (c0758a.url != null && c0758a.url.contains("unidispatch/hotuserrank")) {
                            TiebaStatic.log(new aq("c13665").w("uid", TbadkCoreApplication.getCurrentAccountId()));
                        }
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", c0758a.fid);
                            com.baidu.tieba.im.data.d Mu = com.baidu.tieba.im.util.c.Mu(c0758a.ktW);
                            if (Mu != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", Mu.kww, "task_id", Mu.taskId, "loc", "0");
                                if ((c0758a.userType == 1 || c0758a.userType == 3) && !"0".equals(Mu.taskId)) {
                                    com.baidu.tieba.im.b.a.cVY().Mp(Mu.taskId);
                                }
                            }
                            aq aqVar = new aq("official_message_open_detail");
                            aqVar.w("msg_id", c0758a.kBh / 100);
                            aqVar.dW("official_id", c0758a.kBi);
                            aqVar.an("official_type", c0758a.kBj);
                            aqVar.w("operate_time", System.currentTimeMillis() / 1000);
                            aqVar.w("task_id", c0758a.taskId);
                            aqVar.dW("obj_params1", c0758a.url);
                            TiebaStatic.log(aqVar);
                        }
                        aq aqVar2 = new aq("c13784");
                        aqVar2.w(Constants.EXTRA_SERVICE, c0758a.serviceId);
                        aqVar2.w("task_id", c0758a.taskId);
                        aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.dW("fid", c0758a.fid);
                        if (!TextUtils.isEmpty(c0758a.title)) {
                            if (!TextUtils.isEmpty(c0758a.url)) {
                                String str3 = null;
                                String[] split = c0758a.url.split("tid=");
                                if (split.length > 1) {
                                    int indexOf2 = split[1].indexOf(ETAG.ITEM_SEPARATOR);
                                    if (indexOf2 != -1) {
                                        str3 = split[1].substring(0, indexOf2);
                                    } else {
                                        str3 = split[1].substring(0);
                                    }
                                }
                                aqVar2.dW("tid", str3);
                            }
                            if (c0758a.title.contains("互动量")) {
                                aqVar2.an("obj_source", 2);
                                aqVar2.an("obj_type", 9);
                            } else if (c0758a.title.contains("被加精")) {
                                aqVar2.an("obj_source", 1);
                                aqVar2.an("obj_type", 9);
                            } else if (c0758a.title.contains("热贴榜")) {
                                aqVar2.an("obj_type", 8);
                            } else if (c0758a.userType == 4) {
                                aqVar2.an("obj_type", 10);
                            } else if (c0758a.userType == 3) {
                                aqVar2.an("obj_type", 5);
                            }
                        }
                        if (c0758a.kBi != null && c0758a.kBi.equals("4754917018")) {
                            aqVar2.delete("obj_type");
                            aqVar2.an("obj_type", 9);
                            if (c0758a.url != null) {
                                if (c0758a.url.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (c0758a.url.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (c0758a.url.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = c0758a.url.contains("type=attention-common") ? 5 : -1;
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
            if (!TextUtils.isEmpty(c0758a.src)) {
                this.iIW.setTag(c0758a.src);
                this.iIW.startLoad(c0758a.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.ahj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.ahj.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.ahj.setText("");
        this.iIW.setBackgroundDrawable(null);
        this.iIW.setImageDrawable(null);
        this.gAE.setText("");
        this.gAE.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.krZ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void st(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.iIW.setAutoChangeStyle(z);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105, 1, skinType);
        ao.setViewTextColor(this.ahj, R.color.CAM_X0109, 1, skinType);
        ao.setViewTextColor(this.kvV, R.color.CAM_X0107, 1, skinType);
        SvgManager.bsx().a(this.mArrow, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ao.setViewTextColor(this.gAE, R.color.common_color_10067, 1, skinType);
        ao.setBackgroundResource(this.dyW, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gAE.setVisibility(8);
            this.gAE.setText("");
            return;
        }
        this.gAE.setVisibility(0);
        this.gAE.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String LG(String str) {
        try {
            return Uri.parse(str).getQueryParameter(TbTitleActivityConfig.FORUM_ID);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
