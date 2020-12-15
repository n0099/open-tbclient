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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.im.message.chat.a;
import com.baidu.webkit.internal.ETAG;
import java.net.URISyntaxException;
/* loaded from: classes26.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView ahp;
    private TextView gul;
    private TbImageView iBr;
    private com.baidu.adp.lib.b.b kjY;
    private TextView knV;
    private ImageView mArrow;
    private Context mContext;
    private View mDivider;
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
        this.kjY = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.ahp = (TextView) findViewById(R.id.single_abstract);
        this.iBr = (TbImageView) findViewById(R.id.single_content_pic);
        this.iBr.setAutoChangeStyle(false);
        this.iBr.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.iBr.setConrers(15);
        this.knV = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.mDivider = findViewById(R.id.single_divider);
        this.gul = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.kjY != null) {
                    SingleImageTextView.this.kjY.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0782a c0782a, View view, final int i) {
        if (c0782a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0782a.title)) {
                str = c0782a.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(c0782a.text)) {
                str2 = c0782a.text;
            }
            if (!TextUtils.isEmpty(c0782a.text) && c0782a.text.contains(this.mContext.getResources().getString(R.string.inconformity_forum_rules))) {
                com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(2, c0782a.url) { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(SingleImageTextView.this.mContext, SingleImageTextView.this.MP(c0782a.url), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
                    }

                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
                    }
                };
                int indexOf = c0782a.text.indexOf(this.mContext.getResources().getString(R.string.inconformity_forum_rules));
                SpannableString spannableString = new SpannableString(c0782a.text);
                spannableString.setSpan(fVar, indexOf - 1, indexOf + 6, 33);
                this.ahp.setOnTouchListener(new com.baidu.tieba.view.i(spannableString));
                this.ahp.setText(spannableString);
                this.knV.setText(R.string.bar_tie_complain);
            } else {
                this.ahp.setText(str2);
            }
            if (!TextUtils.isEmpty(c0782a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        int i2;
                        if (c0782a != null && c0782a.url != null && c0782a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(c0782a.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        bf.bua().b(tbPageContext, new String[]{c0782a.url});
                        if (c0782a.url != null && c0782a.url.contains("ForumGradePage")) {
                            ar w = new ar("c13783").w("uid", TbadkCoreApplication.getCurrentAccountId());
                            try {
                                Uri parse = Uri.parse(c0782a.url);
                                String queryParameter = parse.getQueryParameter("forum_id");
                                String queryParameter2 = parse.getQueryParameter("obj_type");
                                w.dY("fid", queryParameter);
                                w.dY("obj_type", queryParameter2);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            TiebaStatic.log(w);
                        }
                        if (c0782a.url != null && c0782a.url.contains("weeklygodview")) {
                            TiebaStatic.log(new ar("c13691").w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_source", 1));
                        }
                        if (c0782a.url != null && c0782a.url.contains("unidispatch/hotuserrank")) {
                            TiebaStatic.log(new ar("c13665").w("uid", TbadkCoreApplication.getCurrentAccountId()));
                        }
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", c0782a.fid);
                            com.baidu.tieba.im.data.d NW = com.baidu.tieba.im.util.e.NW(c0782a.klV);
                            if (NW != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", NW.kqm, "task_id", NW.taskId, "loc", "0");
                                if ((c0782a.userType == 1 || c0782a.userType == 3) && !"0".equals(NW.taskId)) {
                                    com.baidu.tieba.im.b.a.dac().NQ(NW.taskId);
                                }
                            }
                            ar arVar = new ar("official_message_open_detail");
                            arVar.w("msg_id", c0782a.kAy / 100);
                            arVar.dY("official_id", c0782a.kAz);
                            arVar.al("official_type", c0782a.kAA);
                            arVar.w("operate_time", System.currentTimeMillis() / 1000);
                            arVar.w("task_id", c0782a.taskId);
                            arVar.dY("obj_params1", c0782a.url);
                            TiebaStatic.log(arVar);
                        }
                        ar arVar2 = new ar("c13784");
                        arVar2.w(Constants.EXTRA_SERVICE, c0782a.serviceId);
                        arVar2.w("task_id", c0782a.taskId);
                        arVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.dY("fid", c0782a.fid);
                        if (!TextUtils.isEmpty(c0782a.title)) {
                            if (!TextUtils.isEmpty(c0782a.url)) {
                                String str3 = null;
                                String[] split = c0782a.url.split("tid=");
                                if (split.length > 1) {
                                    int indexOf2 = split[1].indexOf(ETAG.ITEM_SEPARATOR);
                                    if (indexOf2 != -1) {
                                        str3 = split[1].substring(0, indexOf2);
                                    } else {
                                        str3 = split[1].substring(0);
                                    }
                                }
                                arVar2.dY("tid", str3);
                            }
                            if (c0782a.title.contains("互动量")) {
                                arVar2.al("obj_source", 2);
                                arVar2.al("obj_type", 9);
                            } else if (c0782a.title.contains("被加精")) {
                                arVar2.al("obj_source", 1);
                                arVar2.al("obj_type", 9);
                            } else if (c0782a.title.contains("热贴榜")) {
                                arVar2.al("obj_type", 8);
                            } else if (c0782a.userType == 4) {
                                arVar2.al("obj_type", 10);
                            } else if (c0782a.userType == 3) {
                                arVar2.al("obj_type", 5);
                            }
                        }
                        if (c0782a.kAz != null && c0782a.kAz.equals("4754917018")) {
                            arVar2.delete("obj_type");
                            arVar2.al("obj_type", 9);
                            if (c0782a.url != null) {
                                if (c0782a.url.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (c0782a.url.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (c0782a.url.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = c0782a.url.contains("type=attention-common") ? 5 : -1;
                                }
                                if (i2 != -1) {
                                    arVar2.delete("obj_source");
                                    arVar2.al("obj_source", i2);
                                }
                            }
                        }
                        TiebaStatic.log(arVar2);
                    }
                });
            }
            if (!TextUtils.isEmpty(c0782a.src)) {
                this.iBr.setTag(c0782a.src);
                this.iBr.startLoad(c0782a.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.ahp.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.ahp.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.ahp.setText("");
        this.iBr.setBackgroundDrawable(null);
        this.iBr.setImageDrawable(null);
        this.gul.setText("");
        this.gul.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kjY = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void se(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.iBr.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, 1, skinType);
        ap.setViewTextColor(this.ahp, R.color.CAM_X0109, 1, skinType);
        ap.setViewTextColor(this.knV, R.color.CAM_X0107, 1, skinType);
        SvgManager.btW().a(this.mArrow, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.gul, R.color.common_color_10067, 1, skinType);
        ap.setBackgroundResource(this.mDivider, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gul.setVisibility(8);
            this.gul.setText("");
            return;
        }
        this.gul.setVisibility(0);
        this.gul.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String MP(String str) {
        try {
            return Uri.parse(str).getQueryParameter(TbTitleActivityConfig.FORUM_ID);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
