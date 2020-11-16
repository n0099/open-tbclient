package com.baidu.tieba.ala.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.BdGridView;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private TextView bEG;
    private BdGridView bEJ;
    private boolean bEy;
    private long bmk;
    private long fXY;
    private com.baidu.tieba.ala.adapter.b hKv;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private long mUserId;
    private View mView;

    public b(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_activity_choose_feedback_reason_layout, (ViewGroup) null);
        this.bEJ = (BdGridView) this.mView.findViewById(a.f.id_feedback_gridview);
        this.bEG = (TextView) this.mView.findViewById(a.f.id_feenback_confirm_btn);
        this.bEG.setEnabled(false);
        this.bEG.setOnClickListener(this);
        this.hKv = new com.baidu.tieba.ala.adapter.b(this.mPageContext);
        this.bEJ.setAdapter((ListAdapter) this.hKv);
        this.bEJ.setOnItemClickListener(new a());
    }

    public void b(long j, long j2, long j3, boolean z, boolean z2) {
        this.bmk = j;
        this.fXY = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bEy = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tieba.ala.data.b item = ((com.baidu.tieba.ala.adapter.b) adapterView.getAdapter()).getItem(i);
            if (item != null) {
                if (item.TL() != 0) {
                    if (b.this.hKv.TJ() == i) {
                        b.this.hKv.ga(-1);
                        b.this.hKv.notifyDataSetChanged();
                        b.this.bEG.setEnabled(false);
                        return;
                    }
                    b.this.hKv.ga(i);
                    b.this.hKv.notifyDataSetChanged();
                    b.this.bEG.setEnabled(true);
                    return;
                }
                com.baidu.live.b.h hVar = new com.baidu.live.b.h(b.this.mPageContext.getPageActivity());
                hVar.a(b.this.bmk, b.this.fXY, b.this.mUserId, b.this.mIsHost);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hVar));
                b.this.mPageContext.getPageActivity().finish();
            }
        }
    }

    public View getView() {
        return this.mView;
    }

    public void onDestroy() {
    }

    public void setData(List<com.baidu.tieba.ala.data.b> list) {
        this.hKv.setData(list);
    }

    public com.baidu.tieba.ala.data.b ckO() {
        if (this.hKv == null || this.hKv.TJ() < 0) {
            return null;
        }
        return this.hKv.getItem(this.hKv.TJ());
    }
}
