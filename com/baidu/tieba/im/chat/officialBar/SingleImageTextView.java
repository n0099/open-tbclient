package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.c;
import com.baidu.webkit.internal.ETAG;
import java.net.URISyntaxException;
/* loaded from: classes13.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView aeA;
    private TextView fqs;
    private TbImageView hiH;
    private com.baidu.adp.lib.b.b iKx;
    private TextView iNy;
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
        this.iKx = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.aeA = (TextView) findViewById(R.id.single_abstract);
        this.hiH = (TbImageView) findViewById(R.id.single_content_pic);
        this.hiH.setAutoChangeStyle(false);
        this.iNy = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.mDivider = findViewById(R.id.single_divider);
        this.fqs = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.iKx != null) {
                    SingleImageTextView.this.iKx.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(R.dimen.ds30), 0, 0);
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(aVar.text)) {
                str2 = aVar.text;
            }
            this.aeA.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (aVar != null && aVar.url != null && aVar.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                            try {
                                SingleImageTextView.this.mContext.startActivity(Intent.parseUri(aVar.url, 1));
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                        if (URLUtil.isHttpUrl(aVar.url) || URLUtil.isHttpsUrl(aVar.url) || aVar.url.startsWith("flt://")) {
                            bc.aWU().b(tbPageContext, new String[]{aVar.url});
                        } else {
                            Uri parse = Uri.parse(aVar.url);
                            if (parse != null) {
                                UtilHelper.dealOneScheme(SingleImageTextView.this.mContext, parse.toString());
                            }
                        }
                        if (aVar.url != null && aVar.url.contains("ForumGradePage")) {
                            ao s = new ao("c13783").s("uid", TbadkCoreApplication.getCurrentAccountId());
                            try {
                                Uri parse2 = Uri.parse(aVar.url);
                                String queryParameter = parse2.getQueryParameter("forum_id");
                                String queryParameter2 = parse2.getQueryParameter("obj_type");
                                s.dk("fid", queryParameter);
                                s.dk("obj_type", queryParameter2);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            TiebaStatic.log(s);
                        }
                        if (aVar.url != null && aVar.url.contains("weeklygodview")) {
                            TiebaStatic.log(new ao("c13691").s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_source", 1));
                        }
                        if (aVar.url != null && aVar.url.contains("unidispatch/hotuserrank")) {
                            TiebaStatic.log(new ao("c13665").s("uid", TbadkCoreApplication.getCurrentAccountId()));
                        }
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", aVar.fid);
                            com.baidu.tieba.im.data.d Hz = com.baidu.tieba.im.util.e.Hz(aVar.iMj);
                            if (Hz != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", Hz.iPP, "task_id", Hz.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(Hz.taskId)) {
                                    com.baidu.tieba.im.b.a.ctt().Ht(Hz.taskId);
                                }
                            }
                            ao aoVar = new ao("official_message_open_detail");
                            aoVar.s("msg_id", aVar.iMq / 100);
                            aoVar.dk("official_id", aVar.iMr);
                            aoVar.ag("official_type", aVar.iMs);
                            aoVar.s("operate_time", System.currentTimeMillis() / 1000);
                            aoVar.s("task_id", aVar.taskId);
                            aoVar.dk("obj_params1", aVar.url);
                            TiebaStatic.log(aoVar);
                        }
                        ao aoVar2 = new ao("c13784");
                        aoVar2.s("uid", TbadkApplication.getCurrentAccountId());
                        aoVar2.dk("fid", aVar.fid);
                        if (!TextUtils.isEmpty(aVar.title)) {
                            if (!TextUtils.isEmpty(aVar.url)) {
                                String str3 = null;
                                String[] split = aVar.url.split("tid=");
                                if (split.length > 1) {
                                    int indexOf = split[1].indexOf(ETAG.ITEM_SEPARATOR);
                                    if (indexOf != -1) {
                                        str3 = split[1].substring(0, indexOf);
                                    } else {
                                        str3 = split[1].substring(0);
                                    }
                                }
                                aoVar2.dk("tid", str3);
                            }
                            if (aVar.title.contains("互动量")) {
                                aoVar2.ag("obj_source", 2);
                                aoVar2.ag("obj_type", 9);
                            } else if (aVar.title.contains("被加精")) {
                                aoVar2.ag("obj_source", 1);
                                aoVar2.ag("obj_type", 9);
                            } else if (aVar.title.contains("热贴榜")) {
                                aoVar2.ag("obj_type", 8);
                            } else if (aVar.userType == 4) {
                                aoVar2.ag("obj_type", 10);
                            } else if (aVar.userType == 3) {
                                aoVar2.ag("obj_type", 5);
                            }
                        }
                        TiebaStatic.log(aoVar2);
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.hiH.setTag(aVar.src);
                this.hiH.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.aeA.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.aeA.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.aeA.setText("");
        this.hiH.setBackgroundDrawable(null);
        this.hiH.setImageDrawable(null);
        this.fqs.setText("");
        this.fqs.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.iKx = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void oX(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.hiH.setAutoChangeStyle(z);
        an.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
        an.setViewTextColor(this.aeA, R.color.cp_cont_c, 1, skinType);
        an.setViewTextColor(this.iNy, R.color.common_color_10039, 1, skinType);
        an.setBackgroundResource(this.mArrow, R.drawable.icon_ba_top_arrow_big, skinType);
        an.setViewTextColor(this.fqs, R.color.common_color_10067, 1, skinType);
        an.setBackgroundResource(this.mDivider, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fqs.setVisibility(8);
            this.fqs.setText("");
            return;
        }
        this.fqs.setVisibility(0);
        this.fqs.setText(str);
    }
}
