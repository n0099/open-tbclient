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
/* loaded from: classes10.dex */
public class b implements View.OnClickListener {
    private boolean bJI;
    private TextView bJQ;
    private BdGridView bJT;
    private long brk;
    private long gmc;
    private com.baidu.tieba.ala.adapter.b idg;
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
        this.bJT = (BdGridView) this.mView.findViewById(a.f.id_feedback_gridview);
        this.bJQ = (TextView) this.mView.findViewById(a.f.id_feenback_confirm_btn);
        this.bJQ.setEnabled(false);
        this.bJQ.setOnClickListener(this);
        this.idg = new com.baidu.tieba.ala.adapter.b(this.mPageContext);
        this.bJT.setAdapter((ListAdapter) this.idg);
        this.bJT.setOnItemClickListener(new a());
    }

    public void b(long j, long j2, long j3, boolean z, boolean z2) {
        this.brk = j;
        this.gmc = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bJI = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tieba.ala.data.b item = ((com.baidu.tieba.ala.adapter.b) adapterView.getAdapter()).getItem(i);
            if (item != null) {
                if (item.Tv() != 0) {
                    if (b.this.idg.Tt() == i) {
                        b.this.idg.eT(-1);
                        b.this.idg.notifyDataSetChanged();
                        b.this.bJQ.setEnabled(false);
                        return;
                    }
                    b.this.idg.eT(i);
                    b.this.idg.notifyDataSetChanged();
                    b.this.bJQ.setEnabled(true);
                    return;
                }
                com.baidu.live.d.h hVar = new com.baidu.live.d.h(b.this.mPageContext.getPageActivity());
                hVar.a(b.this.brk, b.this.gmc, b.this.mUserId, b.this.mIsHost);
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
        this.idg.setData(list);
    }

    public com.baidu.tieba.ala.data.b cog() {
        if (this.idg == null || this.idg.Tt() < 0) {
            return null;
        }
        return this.idg.getItem(this.idg.Tt());
    }
}
