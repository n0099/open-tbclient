package com.baidu.tieba.frs.forumRule.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class c implements n {
    public static BdUniqueId jvB = BdUniqueId.gen();
    private boolean jvC;
    private List<PbContent> mContent;
    private String mTitle;

    public void a(ForumRule forumRule) {
        if (forumRule != null) {
            this.mTitle = forumRule.title;
            this.mContent = forumRule.content;
            this.jvC = forumRule.status.intValue() == 1;
        }
    }

    public String cHn() {
        return this.mTitle;
    }

    public void KA(String str) {
        this.mTitle = str;
    }

    public List<PbContent> cHo() {
        return this.mContent;
    }

    public void dq(List<PbContent> list) {
        this.mContent = list;
    }

    public boolean cHp() {
        return this.jvC;
    }

    public void rj(boolean z) {
        this.jvC = z;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jvB;
    }
}
