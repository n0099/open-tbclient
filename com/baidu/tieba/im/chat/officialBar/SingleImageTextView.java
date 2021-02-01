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
    private TextView gDo;
    private TbImageView iOE;
    private com.baidu.adp.lib.b.b kAg;
    private TextView kEb;
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
        this.kAg = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.agY = (TextView) findViewById(R.id.single_abstract);
        this.iOE = (TbImageView) findViewById(R.id.single_content_pic);
        this.iOE.setAutoChangeStyle(false);
        this.iOE.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.iOE.setConrers(15);
        this.kEb = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.dBb = findViewById(R.id.single_divider);
        this.gDo = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.kAg != null) {
                    SingleImageTextView.this.kAg.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds38);
        int dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds10);
        setPadding(dimension, dimension2, dimension, dimension2);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0760a c0760a, View view, final int i) {
        if (c0760a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0760a.title)) {
                str = c0760a.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(c0760a.text)) {
                str2 = c0760a.text;
            }
            if (!TextUtils.isEmpty(c0760a.text) && c0760a.text.contains(this.mContext.getResources().getString(R.string.inconformity_forum_rules))) {
                com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(2, c0760a.url) { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(SingleImageTextView.this.mContext, SingleImageTextView.this.Mv(c0760a.url), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
                    }

                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
                    }
                };
                int indexOf = c0760a.text.indexOf(this.mContext.getResources().getString(R.string.inconformity_forum_rules));
                SpannableString spannableString = new SpannableString(c0760a.text);
                spannableString.setSpan(fVar, indexOf - 1, indexOf + 6, 33);
                this.agY.setOnTouchListener(new i(spannableString));
                this.agY.setText(spannableString);
                this.kEb.setText(R.string.bar_tie_complain);
            } else {
                this.agY.setText(str2);
            }
            if (!TextUtils.isEmpty(c0760a.url)) {
                if ("com.baidu.tieba://".equals(c0760a.url)) {
                    setEnabled(false);
                } else {
                    setEnabled(true);
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        int i2;
                        if (c0760a != null && c0760a.url != null && c0760a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(c0760a.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        bf.bsV().b(tbPageContext, new String[]{c0760a.url});
                        if (c0760a.url != null && c0760a.url.contains("ForumGradePage")) {
                            ar v = new ar("c13783").v("uid", TbadkCoreApplication.getCurrentAccountId());
                            try {
                                Uri parse = Uri.parse(c0760a.url);
                                String queryParameter = parse.getQueryParameter("forum_id");
                                String queryParameter2 = parse.getQueryParameter("obj_type");
                                v.dR("fid", queryParameter);
                                v.dR("obj_type", queryParameter2);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            TiebaStatic.log(v);
                        }
                        if (c0760a.url != null && c0760a.url.contains("weeklygodview")) {
                            TiebaStatic.log(new ar("c13691").v("uid", TbadkCoreApplication.getCurrentAccountId()).ap("obj_source", 1));
                        }
                        if (c0760a.url != null && c0760a.url.contains("unidispatch/hotuserrank")) {
                            TiebaStatic.log(new ar("c13665").v("uid", TbadkCoreApplication.getCurrentAccountId()));
                        }
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", c0760a.fid);
                            com.baidu.tieba.im.data.d Nj = com.baidu.tieba.im.util.c.Nj(c0760a.kCd);
                            if (Nj != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", Nj.kEC, "task_id", Nj.taskId, "loc", "0");
                                if ((c0760a.userType == 1 || c0760a.userType == 3) && !"0".equals(Nj.taskId)) {
                                    com.baidu.tieba.im.b.a.cXW().Ne(Nj.taskId);
                                }
                            }
                            ar arVar = new ar("official_message_open_detail");
                            arVar.v("msg_id", c0760a.kJm / 100);
                            arVar.dR("official_id", c0760a.kJn);
                            arVar.ap("official_type", c0760a.kJo);
                            arVar.v("operate_time", System.currentTimeMillis() / 1000);
                            arVar.v("task_id", c0760a.taskId);
                            arVar.dR("obj_params1", c0760a.url);
                            TiebaStatic.log(arVar);
                        }
                        ar arVar2 = new ar("c13784");
                        arVar2.v(Constants.EXTRA_SERVICE, c0760a.serviceId);
                        arVar2.v("task_id", c0760a.taskId);
                        arVar2.v("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.dR("fid", c0760a.fid);
                        if (!TextUtils.isEmpty(c0760a.title)) {
                            if (!TextUtils.isEmpty(c0760a.url)) {
                                String str3 = null;
                                String[] split = c0760a.url.split("tid=");
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
                            if (c0760a.title.contains("互动量")) {
                                arVar2.ap("obj_source", 2);
                                arVar2.ap("obj_type", 9);
                            } else if (c0760a.title.contains("被加精")) {
                                arVar2.ap("obj_source", 1);
                                arVar2.ap("obj_type", 9);
                            } else if (c0760a.title.contains("热贴榜")) {
                                arVar2.ap("obj_type", 8);
                            } else if (c0760a.userType == 4) {
                                arVar2.ap("obj_type", 10);
                            } else if (c0760a.userType == 3) {
                                arVar2.ap("obj_type", 5);
                            }
                        }
                        if (c0760a.kJn != null && c0760a.kJn.equals("4754917018")) {
                            arVar2.delete("obj_type");
                            arVar2.ap("obj_type", 9);
                            if (c0760a.url != null) {
                                if (c0760a.url.contains("type=interaction")) {
                                    i2 = 2;
                                } else if (c0760a.url.contains("type=recommend")) {
                                    i2 = 3;
                                } else if (c0760a.url.contains("type=attention-bazhu")) {
                                    i2 = 4;
                                } else {
                                    i2 = c0760a.url.contains("type=attention-common") ? 5 : -1;
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
            if (!TextUtils.isEmpty(c0760a.src)) {
                this.iOE.setTag(c0760a.src);
                this.iOE.startLoad(c0760a.src, 10, false);
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
        this.iOE.setBackgroundDrawable(null);
        this.iOE.setImageDrawable(null);
        this.gDo.setText("");
        this.gDo.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kAg = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void sG(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.iOE.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, 1, skinType);
        ap.setViewTextColor(this.agY, R.color.CAM_X0109, 1, skinType);
        ap.setViewTextColor(this.kEb, R.color.CAM_X0107, 1, skinType);
        SvgManager.bsR().a(this.mArrow, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.gDo, R.color.common_color_10067, 1, skinType);
        ap.setBackgroundResource(this.dBb, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gDo.setVisibility(8);
            this.gDo.setText("");
            return;
        }
        this.gDo.setVisibility(0);
        this.gDo.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Mv(String str) {
        try {
            return Uri.parse(str).getQueryParameter(TbTitleActivityConfig.FORUM_ID);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
