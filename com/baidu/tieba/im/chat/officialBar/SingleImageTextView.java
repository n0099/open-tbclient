package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes3.dex */
public class SingleImageTextView extends RelativeLayout {
    private View bwn;
    private TextView cNI;
    private TbImageView cNz;
    private TextView coW;
    private com.baidu.adp.lib.c.b dQA;
    private TextView dTG;
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
        this.dQA = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.i.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.single_title);
        this.coW = (TextView) findViewById(d.g.single_abstract);
        this.cNz = (TbImageView) findViewById(d.g.single_content_pic);
        this.cNz.setAutoChangeStyle(false);
        this.dTG = (TextView) findViewById(d.g.read_all);
        this.mArrow = (ImageView) findViewById(d.g.arrow);
        this.bwn = findViewById(d.g.single_divider);
        this.cNI = (TextView) findViewById(d.g.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (SingleImageTextView.this.dQA != null) {
                    SingleImageTextView.this.dQA.b(view2, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view2, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(d.e.ds30), 0, 0);
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
            this.coW.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        ax.wg().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                            com.baidu.tieba.im.data.d nX = com.baidu.tieba.im.util.e.nX(aVar.dSo);
                            if (nX != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", nX.dWb, "task_id", nX.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(nX.taskId)) {
                                    com.baidu.tieba.im.b.a.aGZ().nR(nX.taskId);
                                }
                            }
                            al alVar = new al("official_message_open_detail");
                            alVar.f("msg_id", aVar.dSv / 100);
                            alVar.ac("official_id", aVar.dSw);
                            alVar.r("official_type", aVar.dSx);
                            alVar.f("operate_time", System.currentTimeMillis() / 1000);
                            alVar.f("task_id", aVar.taskId);
                            alVar.ac("obj_params1", aVar.url);
                            TiebaStatic.log(alVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.cNz.setTag(aVar.src);
                this.cNz.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.coW.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.coW.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.coW.setText("");
        this.cNz.setBackgroundDrawable(null);
        this.cNz.setImageDrawable(null);
        this.cNI.setText("");
        this.cNI.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dQA = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gL(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.cNz.setAutoChangeStyle(z);
        ak.b(this.mTitle, d.C0126d.common_color_10039, 1, skinType);
        ak.b(this.coW, d.C0126d.cp_cont_c, 1, skinType);
        ak.b(this.dTG, d.C0126d.common_color_10039, 1, skinType);
        ak.d(this.mArrow, d.f.icon_ba_top_arrow_big, skinType);
        ak.b(this.cNI, d.C0126d.common_color_10067, 1, skinType);
        ak.d(this.bwn, d.f.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cNI.setVisibility(8);
            this.cNI.setText("");
            return;
        }
        this.cNI.setVisibility(0);
        this.cNI.setText(str);
    }
}
