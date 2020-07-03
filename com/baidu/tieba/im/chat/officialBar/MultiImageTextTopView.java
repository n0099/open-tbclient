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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes13.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView fqs;
    private com.baidu.adp.lib.b.b iKx;
    private TbImageView iMh;
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
        this.iKx = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.iMh = (TbImageView) findViewById(R.id.top_content_pic);
        this.iMh.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.fqs = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.iKx != null) {
                    MultiImageTextTopView.this.iKx.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (aVar != null && !StringUtils.isNull(aVar.url)) {
                            bc.aWU().b(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", aVar.fid);
                                com.baidu.tieba.im.data.d Hz = com.baidu.tieba.im.util.e.Hz(aVar.iMj);
                                if (Hz != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", Hz.iPP, "task_id", Hz.taskId, "loc", "0");
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(Hz.taskId)) {
                                        com.baidu.tieba.im.b.a.cts().Ht(Hz.taskId);
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
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.iMh.setTag(aVar.src);
                this.iMh.startLoad(aVar.src, 10, false);
            }
        }
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

    public void reset() {
        this.mTitle.setText("");
        this.iMh.setBackgroundDrawable(null);
        this.iMh.setImageDrawable(null);
        this.fqs.setVisibility(8);
        this.fqs.setText("");
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
        this.iMh.setAutoChangeStyle(z);
        an.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1, skinType);
        an.setViewTextColor(this.fqs, R.color.common_color_10067, 1, skinType);
    }
}
