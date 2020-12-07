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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes26.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView guj;
    private com.baidu.adp.lib.b.b kjW;
    private TbImageView klR;
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
        this.kjW = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.klR = (TbImageView) findViewById(R.id.top_content_pic);
        this.klR.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.guj = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.kjW != null) {
                    MultiImageTextTopView.this.kjW.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0782a c0782a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0782a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0782a.title)) {
                str = c0782a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0782a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0782a != null && !StringUtils.isNull(c0782a.url)) {
                            bf.bua().b(tbPageContext, new String[]{c0782a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0782a.fid);
                                com.baidu.tieba.im.data.d NW = com.baidu.tieba.im.util.e.NW(c0782a.klT);
                                if (NW != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", NW.kqk, "task_id", NW.taskId, "loc", "0");
                                    if ((c0782a.userType == 1 || c0782a.userType == 3) && !"0".equals(NW.taskId)) {
                                        com.baidu.tieba.im.b.a.dab().NQ(NW.taskId);
                                    }
                                }
                                ar arVar = new ar("official_message_open_detail");
                                arVar.w("msg_id", c0782a.kAw / 100);
                                arVar.dY("official_id", c0782a.kAx);
                                arVar.al("official_type", c0782a.kAy);
                                arVar.w("operate_time", System.currentTimeMillis() / 1000);
                                arVar.w("task_id", c0782a.taskId);
                                arVar.dY("obj_params1", c0782a.url);
                                TiebaStatic.log(arVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0782a.src)) {
                this.klR.setTag(c0782a.src);
                this.klR.startLoad(c0782a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.guj.setVisibility(8);
            this.guj.setText("");
            return;
        }
        this.guj.setVisibility(0);
        this.guj.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.klR.setBackgroundDrawable(null);
        this.klR.setImageDrawable(null);
        this.guj.setVisibility(8);
        this.guj.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kjW = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void se(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.klR.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1, skinType);
        ap.setViewTextColor(this.guj, R.color.common_color_10067, 1, skinType);
    }
}
