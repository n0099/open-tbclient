package com.baidu.tieba.im.friend;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private com.baidu.tbadk.core.view.w aWd;
    private r aWe = null;
    private ViewGroup aWf = null;
    private boolean aWg;
    private final Context mContext;
    private List<com.baidu.tbadk.coreExtra.relationship.b> mData;

    public p(Context context, boolean z) {
        this.mContext = context;
        this.aWg = z;
    }

    public void a(r rVar) {
        this.aWe = rVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.mData = list;
    }

    public void a(com.baidu.tbadk.core.view.w wVar) {
        this.aWd = wVar;
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
        if (this.aWf == null) {
            this.aWf = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.b bVar = (com.baidu.tbadk.coreExtra.relationship.b) getItem(i);
        if (bVar != null) {
            qVar = a(view != null ? view.getTag() : null, bVar);
        } else {
            qVar = null;
        }
        if (qVar != null) {
            return qVar.Xm;
        }
        return null;
    }

    private q a(Object obj, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        q qVar;
        if (obj == null) {
            qVar = Ng();
        } else {
            qVar = (q) obj;
        }
        if (this.aWe != null) {
            this.aWe.a(qVar.Xm, bVar);
        }
        a(bVar, qVar, bVar.getUserPortrait());
        qVar.aEq.setText(bVar.getUserName());
        if (this.aWg) {
            qVar.aWh.setVisibility(8);
        } else {
            qVar.aWh.setTagData(bVar);
        }
        if (this.mContext instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.mContext).getLayoutMode().h(qVar.Xm);
        }
        return qVar;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.b bVar, q qVar, String str) {
        if (bVar != null) {
            qVar.aVK.setTag(str);
            qVar.aVK.c(str, 12, false);
        }
    }

    private q Ng() {
        q qVar = new q(this);
        qVar.Xm = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.invite_friend_list_item, null);
        qVar.aVK = (HeadImageView) qVar.Xm.findViewById(com.baidu.tieba.v.photo);
        qVar.aVK.setIsRound(false);
        qVar.aEq = (TextView) qVar.Xm.findViewById(com.baidu.tieba.v.txt_user_name);
        qVar.aWh = (TbCheckBox) qVar.Xm.findViewById(com.baidu.tieba.v.ckb_select);
        if (this.aWd != null) {
            qVar.aWh.setStatedChangedListener(this.aWd);
        }
        qVar.Xm.setTag(qVar);
        return qVar;
    }
}
