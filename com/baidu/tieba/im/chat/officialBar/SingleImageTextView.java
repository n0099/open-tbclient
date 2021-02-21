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
import com.baidu.tieba.view.i;
import com.baidu.webkit.internal.ETAG;
import java.net.URISyntaxException;
/* loaded from: classes8.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView agY;
    private View dBb;
    private TextView gDC;
    private TbImageView iOS;
    private com.baidu.adp.lib.b.b kAu;
    private TextView kEp;
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
        this.kAu = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.agY = (TextView) findViewById(R.id.single_abstract);
        this.iOS = (TbImageView) findViewById(R.id.single_content_pic);
        this.iOS.setAutoChangeStyle(false);
        this.iOS.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.iOS.setConrers(15);
        this.kEp = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.dBb = findViewById(R.id.single_divider);
        this.gDC = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.kAu != null) {
                    SingleImageTextView.this.kAu.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0761a c0761a, View view, final int i) {
        if (c0761a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0761a.title)) {
                str = c0761a.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(c0761a.text)) {
                str2 = c0761a.text;
            }
            if (!TextUtils.isEmpty(c0761a.text) && c0761a.text.contains(this.mContext.getResources().getString(R.string.inconformity_forum_rules))) {
                com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(2, c0761a.url) { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(SingleImageTextView.this.mContext, SingleImageTextView.this.Mw(c0761a.url), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
                    }

                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
                    }
                };
                int indexOf = c0761a.text.indexOf(this.mContext.getResources().getString(R.string.inconformity_forum_rules));
                SpannableString spannableString = new SpannableString(c0761a.text);
                spannableString.setSpan(fVar, indexOf - 1, indexOf + 6, 33);
                this.agY.setOnTouchListener(new i(spannableString));
                this.agY.setText(spannableString);
                this.kEp.setText(R.string.bar_tie_complain);
            } else {
                this.agY.setText(str2);
            }
            if (!TextUtils.isEmpty(c0761a.url)) {
                if ("com.baidu.tieba://".equals(c0761a.url)) {
                    setEnabled(false);
                } else {
                    setEnabled(true);
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        int i2;
                        if (c0761a != null && c0761a.url != null && c0761a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(c0761a.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        bf.bsV().b(tbPageContext, new String[]{c0761a.url});
                        if (c0761a.url != null && c0761a.url.contains("ForumGradePage")) {
                            ar v = new ar("c13783").v("uid", TbadkCoreApplication.getCurrentAccountId());
                            try {
                                Uri parse = Uri.parse(c0761a.url);
                                String queryParameter = parse.getQueryParameter("forum_id");
                                String queryParameter2 = parse.getQueryParameter("obj_type");
                                v.dR("fid", queryParameter);
                                v.dR("obj_type", queryParameter2);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            TiebaStatic.log(v);
                        }
                        if (c0761a.url != null && c0761a.url.contains("weeklygodview")) {
                            TiebaStatic.log(new ar("c13691").v("uid", TbadkCoreApplication.getCurrentAccountId()).ap("obj_source", 1));
                        }
                        if (c0761a.url != null && c0761a.url.contains("unidispatch/hotuserrank")) {
                            TiebaStatic.log(new ar("c13665").v("uid", TbadkCoreApplication.getCurrentAccountId()));
                        }
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", c0761a.fid);
                            com.baidu.tieba.im.data.d Nk = com.baidu.tieba.im.util.c.Nk(c0761a.kCr);
                            if (Nk != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", Nk.kEQ, "task_id", Nk.taskId, "loc", "0");
                                if ((c0761a.userType == 1 || c0761a.userType == 3) && !"0".equals(Nk.taskId)) {
                                    com.baidu.tieba.im.b.a.cYd().Nf(Nk.taskId);
                                }
                            }
                            ar arVar = new ar("official_message_open_detail");
                            arVar.v("msg_id", c0761a.kJA / 100);
                            arVar.dR("official_id", c0761a.kJB);
                            arVar.ap("official_type", c0761a.kJC);
                            arVar.v("operate_time", System.currentTimeMillis() / 1000);
                            arVar.v("task_id", c0761a.taskId);
                            arVar.dR("obj_params1", c0761a.url);
                            TiebaStatic.log(arVar);
                        }
                        ar arVar2 = new ar("c13784");
                        arVar2.v(Constants.EXTRA_SERVICE, c0761a.serviceId);
                        arVar2.v("task_id", c0761a.taskId);
                        arVar2.v("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.dR("fid", c0761a.fid);
                        if (!TextUtils.isEmpty(c0761a.title)) {
                            if (!TextUtils.isEmpty(c0761a.url)) {
                                String str3 = null;
                                String[] split = c0761a.url.split("tid=");
                                if (split.length > 1) {
                                    int indexOf2 = split[1].indexOf(ETAG.ITEM_SEPARATOR);
                                    if (indexOf2 != -1) {
                                        str3 = split[1].substring(0, indexOf2);
                                    } else {
                                        str3 = split[1].substring(0);
                                    }
                                }
                                arVar2.dR("tid", str3);
                            }
                            if (c0761a.title.contains("互动量")) {
                                arVar2.ap("obj_source", 2);
                                arVar2.ap("obj_type", 9);
                            } else if (c0761a.title.contains("被加精")) {
                                arVar2.ap("obj_source", 1);
                                arVar2.ap("obj_type", 9);
                            } else if (c0761a.title.contains("热贴榜")) {
                                arVar2.ap("obj_type", 8);
                            } else if (c0761a.userType == 4) {
                                arVar2.ap("obj_type", 10);
                            } else if (c0761a.userType == 3) {
                                arVar2.ap("obj_type", 5);
                            }
                        }
                        if (c0761a.kJB != null && c0761a.kJB.equals("4754917018")) {
                            arVar2.delete("obj_type");
                            arVar2.ap("obj_type", 9);
                            if (c0761a.url != null) {
                                if (c0761a.url.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (c0761a.url.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (c0761a.url.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = c0761a.url.contains("type=attention-common") ? 5 : -1;
                                }
                                if (i2 != -1) {
                                    arVar2.delete("obj_source");
                                    arVar2.ap("obj_source", i2);
                                }
                            }
                        }
                        TiebaStatic.log(arVar2);
                    }
                });
            }
            if (!TextUtils.isEmpty(c0761a.src)) {
                this.iOS.setTag(c0761a.src);
                this.iOS.startLoad(c0761a.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.agY.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.agY.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.agY.setText("");
        this.iOS.setBackgroundDrawable(null);
        this.iOS.setImageDrawable(null);
        this.gDC.setText("");
        this.gDC.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kAu = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void sG(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.iOS.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, 1, skinType);
        ap.setViewTextColor(this.agY, R.color.CAM_X0109, 1, skinType);
        ap.setViewTextColor(this.kEp, R.color.CAM_X0107, 1, skinType);
        SvgManager.bsR().a(this.mArrow, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.gDC, R.color.common_color_10067, 1, skinType);
        ap.setBackgroundResource(this.dBb, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gDC.setVisibility(8);
            this.gDC.setText("");
            return;
        }
        this.gDC.setVisibility(0);
        this.gDC.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Mw(String str) {
        try {
            return Uri.parse(str).getQueryParameter(TbTitleActivityConfig.FORUM_ID);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
