package com.baidu.tieba.frs.forumRule.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class c implements n {
    public static BdUniqueId jvn = BdUniqueId.gen();
    private boolean jvo;
    private List<PbContent> mContent;
    private String mTitle;

    public void a(ForumRule forumRule) {
        if (forumRule != null) {
            this.mTitle = forumRule.title;
            this.mContent = forumRule.content;
            this.jvo = forumRule.status.intValue() == 1;
        }
    }

    public String cHg() {
        return this.mTitle;
    }

    public void Kz(String str) {
        this.mTitle = str;
    }

    public List<PbContent> cHh() {
        return this.mContent;
    }

    public void dq(List<PbContent> list) {
        this.mContent = list;
    }

    public boolean cHi() {
        return this.jvo;
    }

    public void rj(boolean z) {
        this.jvo = z;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jvn;
    }
}
