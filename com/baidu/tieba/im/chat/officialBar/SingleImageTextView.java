package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.c;
import java.net.URISyntaxException;
/* loaded from: classes13.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView KA;
    private TextView eoM;
    private TbImageView geG;
    private com.baidu.adp.lib.b.b huc;
    private TextView hxe;
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
        this.huc = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.KA = (TextView) findViewById(R.id.single_abstract);
        this.geG = (TbImageView) findViewById(R.id.single_content_pic);
        this.geG.setAutoChangeStyle(false);
        this.hxe = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.mDivider = findViewById(R.id.single_divider);
        this.eoM = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.huc != null) {
                    SingleImageTextView.this.huc.onItemViewLongClick(view, 9, SingleImageTextView.this.mPosition, 0L);
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
            this.KA.setText(str2);
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
                        ba.aGK().b(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", aVar.fid);
                            com.baidu.tieba.im.data.d DD = com.baidu.tieba.im.util.e.DD(aVar.hvO);
                            if (DD != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", DD.hzv, "task_id", DD.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(DD.taskId)) {
                                    com.baidu.tieba.im.b.a.bYx().Dx(DD.taskId);
                                }
                            }
                            an anVar = new an("official_message_open_detail");
                            anVar.s("msg_id", aVar.hvV / 100);
                            anVar.cx("official_id", aVar.hvW);
                            anVar.X("official_type", aVar.hvX);
                            anVar.s("operate_time", System.currentTimeMillis() / 1000);
                            anVar.s("task_id", aVar.taskId);
                            anVar.cx("obj_params1", aVar.url);
                            TiebaStatic.log(anVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.geG.setTag(aVar.src);
                this.geG.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.KA.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.KA.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.KA.setText("");
        this.geG.setBackgroundDrawable(null);
        this.geG.setImageDrawable(null);
        this.eoM.setText("");
        this.eoM.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.huc = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void nn(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.geG.setAutoChangeStyle(z);
        am.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
        am.setViewTextColor(this.KA, R.color.cp_cont_c, 1, skinType);
        am.setViewTextColor(this.hxe, R.color.common_color_10039, 1, skinType);
        am.setBackgroundResource(this.mArrow, R.drawable.icon_ba_top_arrow_big, skinType);
        am.setViewTextColor(this.eoM, R.color.common_color_10067, 1, skinType);
        am.setBackgroundResource(this.mDivider, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.eoM.setVisibility(8);
            this.eoM.setText("");
            return;
        }
        this.eoM.setVisibility(0);
        this.eoM.setText(str);
    }
}
