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
    private com.baidu.tbadk.core.view.w aVP;
    private r aVQ = null;
    private ViewGroup aVR = null;
    private boolean aVS;
    private final Context mContext;
    private List<com.baidu.tbadk.coreExtra.relationship.b> mData;

    public p(Context context, boolean z) {
        this.mContext = context;
        this.aVS = z;
    }

    public void a(r rVar) {
        this.aVQ = rVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.mData = list;
    }

    public void a(com.baidu.tbadk.core.view.w wVar) {
        this.aVP = wVar;
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
        if (this.aVR == null) {
            this.aVR = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.b bVar = (com.baidu.tbadk.coreExtra.relationship.b) getItem(i);
        if (bVar != null) {
            qVar = a(view != null ? view.getTag() : null, bVar);
        } else {
            qVar = null;
        }
        if (qVar != null) {
            return qVar.Xi;
        }
        return null;
    }

    private q a(Object obj, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        q qVar;
        if (obj == null) {
            qVar = Nc();
        } else {
            qVar = (q) obj;
        }
        if (this.aVQ != null) {
            this.aVQ.a(qVar.Xi, bVar);
        }
        a(bVar, qVar, bVar.getUserPortrait());
        qVar.aEg.setText(bVar.getUserName());
        if (this.aVS) {
            qVar.aVT.setVisibility(8);
        } else {
            qVar.aVT.setTagData(bVar);
        }
        if (this.mContext instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.mContext).getLayoutMode().h(qVar.Xi);
        }
        return qVar;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.b bVar, q qVar, String str) {
        if (bVar != null) {
            qVar.aVw.setTag(str);
            qVar.aVw.c(str, 12, false);
        }
    }

    private q Nc() {
        q qVar = new q(this);
        qVar.Xi = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.invite_friend_list_item, null);
        qVar.aVw = (HeadImageView) qVar.Xi.findViewById(com.baidu.tieba.v.photo);
        qVar.aVw.setIsRound(false);
        qVar.aEg = (TextView) qVar.Xi.findViewById(com.baidu.tieba.v.txt_user_name);
        qVar.aVT = (TbCheckBox) qVar.Xi.findViewById(com.baidu.tieba.v.ckb_select);
        if (this.aVP != null) {
            qVar.aVT.setStatedChangedListener(this.aVP);
        }
        qVar.Xi.setTag(qVar);
        return qVar;
    }
}
