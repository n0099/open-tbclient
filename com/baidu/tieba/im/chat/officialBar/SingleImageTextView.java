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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.c;
import java.net.URISyntaxException;
/* loaded from: classes3.dex */
public class SingleImageTextView extends RelativeLayout {
    private TextView VB;
    private View aMY;
    private TbImageView faO;
    private TextView faX;
    private com.baidu.adp.lib.c.b gsC;
    private TextView gvG;
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
        this.gsC = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.single_title);
        this.VB = (TextView) findViewById(R.id.single_abstract);
        this.faO = (TbImageView) findViewById(R.id.single_content_pic);
        this.faO.setAutoChangeStyle(false);
        this.gvG = (TextView) findViewById(R.id.read_all);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.aMY = findViewById(R.id.single_divider);
        this.faX = (TextView) findViewById(R.id.show_time_single);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.SingleImageTextView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SingleImageTextView.this.gsC != null) {
                    SingleImageTextView.this.gsC.b(view, 9, SingleImageTextView.this.mPosition, 0L);
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
            this.VB.setText(str2);
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
                        ba.aiz().c(tbPageContext, new String[]{aVar.url});
                        if (i == 1) {
                            TiebaStatic.eventStat(SingleImageTextView.this.mContext, "official_msg_ck", "click", 1, "fid", aVar.fid);
                            com.baidu.tieba.im.data.d yQ = com.baidu.tieba.im.util.e.yQ(aVar.guq);
                            if (yQ != null) {
                                TiebaStatic.eventStat(SingleImageTextView.this.mContext, "message_open_detail", "click", 1, "task_type", yQ.gya, "task_id", yQ.taskId, "loc", "0");
                                if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(yQ.taskId)) {
                                    com.baidu.tieba.im.b.a.bDO().yK(yQ.taskId);
                                }
                            }
                            am amVar = new am("official_message_open_detail");
                            amVar.l("msg_id", aVar.gux / 100);
                            amVar.bT("official_id", aVar.guy);
                            amVar.P("official_type", aVar.guz);
                            amVar.l("operate_time", System.currentTimeMillis() / 1000);
                            amVar.l("task_id", aVar.taskId);
                            amVar.bT("obj_params1", aVar.url);
                            TiebaStatic.log(amVar);
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.faO.setTag(aVar.src);
                this.faO.startLoad(aVar.src, 10, false);
            }
            ViewGroup.LayoutParams layoutParams = this.VB.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                this.VB.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.VB.setText("");
        this.faO.setBackgroundDrawable(null);
        this.faO.setImageDrawable(null);
        this.faX.setText("");
        this.faX.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.gsC = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void lA(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.faO.setAutoChangeStyle(z);
        al.c(this.mTitle, R.color.common_color_10039, 1, skinType);
        al.c(this.VB, R.color.cp_cont_c, 1, skinType);
        al.c(this.gvG, R.color.common_color_10039, 1, skinType);
        al.g(this.mArrow, R.drawable.icon_ba_top_arrow_big, skinType);
        al.c(this.faX, R.color.common_color_10067, 1, skinType);
        al.g(this.aMY, R.drawable.multi_single_divider_selector, skinType);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.faX.setVisibility(8);
            this.faX.setText("");
            return;
        }
        this.faX.setVisibility(0);
        this.faX.setText(str);
    }
}
