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
/* loaded from: classes8.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView gFk;
    private com.baidu.adp.lib.b.b kwE;
    private TbImageView kyz;
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
        this.kwE = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.kyz = (TbImageView) findViewById(R.id.top_content_pic);
        this.kyz.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.gFk = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.kwE != null) {
                    MultiImageTextTopView.this.kwE.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0775a c0775a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0775a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0775a.title)) {
                str = c0775a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0775a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0775a != null && !StringUtils.isNull(c0775a.url)) {
                            be.bwv().b(tbPageContext, new String[]{c0775a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0775a.fid);
                                com.baidu.tieba.im.data.d NC = com.baidu.tieba.im.util.c.NC(c0775a.kyB);
                                if (NC != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", NC.kBb, "task_id", NC.taskId, "loc", "0");
                                    if ((c0775a.userType == 1 || c0775a.userType == 3) && !"0".equals(NC.taskId)) {
                                        com.baidu.tieba.im.b.a.cZQ().Nx(NC.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.w("msg_id", c0775a.kFM / 100);
                                aqVar.dX("official_id", c0775a.kFN);
                                aqVar.an("official_type", c0775a.kFO);
                                aqVar.w("operate_time", System.currentTimeMillis() / 1000);
                                aqVar.w("task_id", c0775a.taskId);
                                aqVar.dX("obj_params1", c0775a.url);
                                TiebaStatic.log(aqVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0775a.src)) {
                this.kyz.setTag(c0775a.src);
                this.kyz.startLoad(c0775a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gFk.setVisibility(8);
            this.gFk.setText("");
            return;
        }
        this.gFk.setVisibility(0);
        this.gFk.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.kyz.setBackgroundDrawable(null);
        this.kyz.setImageDrawable(null);
        this.gFk.setVisibility(8);
        this.gFk.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kwE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void sx(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.kyz.setAutoChangeStyle(z);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1, skinType);
        ao.setViewTextColor(this.gFk, R.color.common_color_10067, 1, skinType);
    }
}
