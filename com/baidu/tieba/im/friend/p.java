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
    private final TbPageContextSupport bau;
    private ai bav;
    private r baw = null;
    private ViewGroup bax = null;
    private boolean bay;
    private List<com.baidu.tbadk.coreExtra.relationship.b> mData;

    public p(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.bau = tbPageContextSupport;
        this.bay = z;
    }

    public void a(r rVar) {
        this.baw = rVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.mData = list;
    }

    public void a(ai aiVar) {
        this.bav = aiVar;
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
        if (this.bax == null) {
            this.bax = viewGroup;
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
            qVar = Or();
        } else {
            qVar = (q) obj;
        }
        if (this.baw != null) {
            this.baw.a(qVar.rootView, bVar);
        }
        a(bVar, qVar, bVar.getUserPortrait());
        qVar.aFV.setText(bVar.getUserName());
        if (this.bay) {
            qVar.baz.setVisibility(8);
        } else {
            qVar.baz.setTagData(bVar);
        }
        if (this.bau instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.bau).getLayoutMode().h(qVar.rootView);
        }
        return qVar;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.b bVar, q qVar, String str) {
        if (bVar != null) {
            qVar.bab.setTag(str);
            qVar.bab.d(str, 12, false);
        }
    }

    private q Or() {
        q qVar = new q(this);
        qVar.rootView = com.baidu.adp.lib.g.b.ek().inflate(this.bau.getPageContext().getContext(), com.baidu.tieba.x.invite_friend_list_item, null);
        qVar.bab = (HeadImageView) qVar.rootView.findViewById(com.baidu.tieba.w.photo);
        qVar.bab.setIsRound(false);
        qVar.aFV = (TextView) qVar.rootView.findViewById(com.baidu.tieba.w.txt_user_name);
        qVar.baz = (TbCheckBox) qVar.rootView.findViewById(com.baidu.tieba.w.ckb_select);
        if (this.bav != null) {
            qVar.baz.setStatedChangedListener(this.bav);
        }
        qVar.rootView.setTag(qVar);
        return qVar;
    }
}
