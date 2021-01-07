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
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private TextView bOC;
    private BdGridView bOF;
    private boolean bOu;
    private long bvY;
    private long gqJ;
    private com.baidu.tieba.ala.adapter.b ihR;
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
        this.bOF = (BdGridView) this.mView.findViewById(a.f.id_feedback_gridview);
        this.bOC = (TextView) this.mView.findViewById(a.f.id_feenback_confirm_btn);
        this.bOC.setEnabled(false);
        this.bOC.setOnClickListener(this);
        this.ihR = new com.baidu.tieba.ala.adapter.b(this.mPageContext);
        this.bOF.setAdapter((ListAdapter) this.ihR);
        this.bOF.setOnItemClickListener(new a());
    }

    public void b(long j, long j2, long j3, boolean z, boolean z2) {
        this.bvY = j;
        this.gqJ = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bOu = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tieba.ala.data.b item = ((com.baidu.tieba.ala.adapter.b) adapterView.getAdapter()).getItem(i);
            if (item != null) {
                if (item.Xo() != 0) {
                    if (b.this.ihR.Xm() == i) {
                        b.this.ihR.gA(-1);
                        b.this.ihR.notifyDataSetChanged();
                        b.this.bOC.setEnabled(false);
                        return;
                    }
                    b.this.ihR.gA(i);
                    b.this.ihR.notifyDataSetChanged();
                    b.this.bOC.setEnabled(true);
                    return;
                }
                com.baidu.live.d.h hVar = new com.baidu.live.d.h(b.this.mPageContext.getPageActivity());
                hVar.a(b.this.bvY, b.this.gqJ, b.this.mUserId, b.this.mIsHost);
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
        this.ihR.setData(list);
    }

    public com.baidu.tieba.ala.data.b crY() {
        if (this.ihR == null || this.ihR.Xm() < 0) {
            return null;
        }
        return this.ihR.getItem(this.ihR.Xm());
    }
}
