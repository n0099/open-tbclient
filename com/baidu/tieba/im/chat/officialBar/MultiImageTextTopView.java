package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes7.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView gAE;
    private com.baidu.adp.lib.b.b krZ;
    private TbImageView ktU;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.krZ = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.ktU = (TbImageView) findViewById(R.id.top_content_pic);
        this.ktU.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.gAE = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.krZ != null) {
                    MultiImageTextTopView.this.krZ.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0758a c0758a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0758a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0758a.title)) {
                str = c0758a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0758a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0758a != null && !StringUtils.isNull(c0758a.url)) {
                            be.bsB().b(tbPageContext, new String[]{c0758a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0758a.fid);
                                com.baidu.tieba.im.data.d Mu = com.baidu.tieba.im.util.c.Mu(c0758a.ktW);
                                if (Mu != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", Mu.kww, "task_id", Mu.taskId, "loc", "0");
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
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0758a.src)) {
                this.ktU.setTag(c0758a.src);
                this.ktU.startLoad(c0758a.src, 10, false);
            }
        }
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

    public void reset() {
        this.mTitle.setText("");
        this.ktU.setBackgroundDrawable(null);
        this.ktU.setImageDrawable(null);
        this.gAE.setVisibility(8);
        this.gAE.setText("");
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
        this.ktU.setAutoChangeStyle(z);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1, skinType);
        ao.setViewTextColor(this.gAE, R.color.common_color_10067, 1, skinType);
    }
}
