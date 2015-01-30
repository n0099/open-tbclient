package com.baidu.tieba.im.friend;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.ai;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private final TbPageContextSupport bbQ;
    private ai bbR;
    private boolean bbT;
    private List<com.baidu.tbadk.coreExtra.relationship.b> mData;
    private r bbS = null;
    private ViewGroup aqv = null;

    public p(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.bbQ = tbPageContextSupport;
        this.bbT = z;
    }

    public void a(r rVar) {
        this.bbS = rVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.mData = list;
    }

    public void a(ai aiVar) {
        this.bbR = aiVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        q qVar;
        if (this.aqv == null) {
            this.aqv = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.b bVar = (com.baidu.tbadk.coreExtra.relationship.b) getItem(i);
        if (bVar != null) {
            qVar = a(view != null ? view.getTag() : null, bVar);
        } else {
            qVar = null;
        }
        if (qVar != null) {
            return qVar.rootView;
        }
        return null;
    }

    private q a(Object obj, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        q qVar;
        if (obj == null) {
            qVar = ON();
        } else {
            qVar = (q) obj;
        }
        if (this.bbS != null) {
            this.bbS.a(qVar.rootView, bVar);
        }
        a(bVar, qVar, bVar.getUserPortrait());
        qVar.aHf.setText(bVar.getUserName());
        if (this.bbT) {
            qVar.bbU.setVisibility(8);
        } else {
            qVar.bbU.setTagData(bVar);
        }
        if (this.bbQ instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.bbQ).getLayoutMode().h(qVar.rootView);
        }
        return qVar;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.b bVar, q qVar, String str) {
        if (bVar != null) {
            qVar.bby.setTag(str);
            qVar.bby.d(str, 12, false);
        }
    }

    private q ON() {
        q qVar = new q(this);
        qVar.rootView = com.baidu.adp.lib.g.b.ei().inflate(this.bbQ.getPageContext().getContext(), com.baidu.tieba.x.invite_friend_list_item, null);
        qVar.bby = (HeadImageView) qVar.rootView.findViewById(com.baidu.tieba.w.photo);
        qVar.bby.setIsRound(false);
        qVar.aHf = (TextView) qVar.rootView.findViewById(com.baidu.tieba.w.txt_user_name);
        qVar.bbU = (TbCheckBox) qVar.rootView.findViewById(com.baidu.tieba.w.ckb_select);
        if (this.bbR != null) {
            qVar.bbU.setStatedChangedListener(this.bbR);
        }
        qVar.rootView.setTag(qVar);
        return qVar;
    }
}
