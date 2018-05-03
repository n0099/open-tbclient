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
    private TextView cNF;
    private TbImageView cNw;
    private TextView coT;
    private com.baidu.adp.lib.c.b dQx;
    private TextView dTD;
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
        this.dQx = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.i.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.single_title);
        this.coT = (TextView) findViewById(d.g.single_abstract);
        this.cNw = (TbImageView) findViewById(d.g.single_content_pic);
        this.cNw.setAutoChangeStyle(false);
        this.dTD = (TextView) findViewById(d.g.read_all);
        this.mArrow = (ImageView) findViewById(d.g.arrow);
        this.bwn = findViewById(d.g.single_divider);
        this.cNF = (TextView) findViewById(d.g.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (SingleImageTextView.this.dQx != null) {
                    SingleImageTextView.this.dQx.b(view2, 9, SingleImageTextView.this.mPosition, 0L);
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
            this.coT.setText(str2);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        ax.wg().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                            com.baidu.tieba.im.data.d nX = com.baidu.tieba.im.util.e.nX(aVar.dSl);
                            if (nX != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", nX.dVY, "task_id", nX.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(nX.taskId)) {
                                    com.baidu.tieba.im.b.a.aGZ().nR(nX.taskId);
                                }
                            }
                            al alVar = new al("official_message_open_detail");
                            alVar.f("msg_id", aVar.dSs / 100);
                            alVar.ac("official_id", aVar.dSt);
                            alVar.r("official_type", aVar.dSu);
                            alVar.f("operate_time", System.currentTimeMillis() / 1000);
                            alVar.f("task_id", aVar.taskId);
                            alVar.ac("obj_params1", aVar.url);
                            TiebaStatic.log(alVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.cNw.setTag(aVar.src);
                this.cNw.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.coT.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.coT.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.coT.setText("");
        this.cNw.setBackgroundDrawable(null);
        this.cNw.setImageDrawable(null);
        this.cNF.setText("");
        this.cNF.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.dQx = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void gL(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.cNw.setAutoChangeStyle(z);
        ak.b(this.mTitle, d.C0126d.common_color_10039, 1, skinType);
        ak.b(this.coT, d.C0126d.cp_cont_c, 1, skinType);
        ak.b(this.dTD, d.C0126d.common_color_10039, 1, skinType);
        ak.d(this.mArrow, d.f.icon_ba_top_arrow_big, skinType);
        ak.b(this.cNF, d.C0126d.common_color_10067, 1, skinType);
        ak.d(this.bwn, d.f.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cNF.setVisibility(8);
            this.cNF.setText("");
            return;
        }
        this.cNF.setVisibility(0);
        this.cNF.setText(str);
    }
}
