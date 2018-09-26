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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes3.dex */
public class SingleImageTextView extends RelativeLayout {
    private View bNG;
    private TextView cES;
    private TextView deC;
    private TbImageView det;
    private com.baidu.adp.lib.c.b erR;
    private TextView euY;
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
        this.erR = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(e.h.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(e.g.single_title);
        this.cES = (TextView) findViewById(e.g.single_abstract);
        this.det = (TbImageView) findViewById(e.g.single_content_pic);
        this.det.setAutoChangeStyle(false);
        this.euY = (TextView) findViewById(e.g.read_all);
        this.mArrow = (ImageView) findViewById(e.g.arrow);
        this.bNG = findViewById(e.g.single_divider);
        this.deC = (TextView) findViewById(e.g.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.erR != null) {
                    SingleImageTextView.this.erR.b(view, 9, SingleImageTextView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding(0, (int) this.mContext.getResources().getDimension(e.C0141e.ds30), 0, 0);
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
            this.cES.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ay.AN().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                            com.baidu.tieba.im.data.d py = com.baidu.tieba.im.util.e.py(aVar.etH);
                            if (py != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", py.exu, "task_id", py.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(py.taskId)) {
                                    com.baidu.tieba.im.b.a.aPK().ps(py.taskId);
                                }
                            }
                            am amVar = new am("official_message_open_detail");
                            amVar.g("msg_id", aVar.etO / 100);
                            amVar.al("official_id", aVar.etP);
                            amVar.w("official_type", aVar.etQ);
                            amVar.g("operate_time", System.currentTimeMillis() / 1000);
                            amVar.g("task_id", aVar.taskId);
                            amVar.al("obj_params1", aVar.url);
                            TiebaStatic.log(amVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.det.setTag(aVar.src);
                this.det.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.cES.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.cES.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.cES.setText("");
        this.det.setBackgroundDrawable(null);
        this.det.setImageDrawable(null);
        this.deC.setText("");
        this.deC.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.erR = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void hD(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.det.setAutoChangeStyle(z);
        al.b(this.mTitle, e.d.common_color_10039, 1, skinType);
        al.b(this.cES, e.d.cp_cont_c, 1, skinType);
        al.b(this.euY, e.d.common_color_10039, 1, skinType);
        al.d(this.mArrow, e.f.icon_ba_top_arrow_big, skinType);
        al.b(this.deC, e.d.common_color_10067, 1, skinType);
        al.d(this.bNG, e.f.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.deC.setVisibility(8);
            this.deC.setText("");
            return;
        }
        this.deC.setVisibility(0);
        this.deC.setText(str);
    }
}
