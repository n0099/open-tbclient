package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ai {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private String hZe;
    private List<FrsTabInfo> jet;
    private final List<com.baidu.tbadk.mainTab.b> jeu = new LinkedList();
    private Context mContext;

    public ai(Context context, List<FrsTabInfo> list) {
        this.jet = list;
        this.mContext = context;
    }

    public boolean Ax(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.x.isEmpty(this.jet)) {
            for (FrsTabInfo frsTabInfo : this.jet) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bEu() {
        return this.jet;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.jeu) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.jeu.add(bVar);
        }
    }

    public void cHl() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.jet) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.jeu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(linkedList2)) {
            this.jet.removeAll(linkedList2);
        }
        this.jeu.clear();
        if (!com.baidu.tbadk.core.util.x.isEmpty(linkedList)) {
            this.jeu.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> cEE() {
        return this.jeu;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    public String getForumGameLabel() {
        return this.forumGameLabel;
    }

    public void IT(String str) {
        this.hZe = str;
    }

    public String cHm() {
        return this.hZe;
    }
}
