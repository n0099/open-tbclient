package com.baidu.tieba.frs.forumRule.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class c implements n {
    public static BdUniqueId jun = BdUniqueId.gen();
    private boolean juo;
    private List<PbContent> mContent;
    private String mTitle;

    public void a(ForumRule forumRule) {
        if (forumRule != null) {
            this.mTitle = forumRule.title;
            this.mContent = forumRule.content;
            this.juo = forumRule.status.intValue() == 1;
        }
    }

    public String cJK() {
        return this.mTitle;
    }

    public void KZ(String str) {
        this.mTitle = str;
    }

    public List<PbContent> cJL() {
        return this.mContent;
    }

    public void dv(List<PbContent> list) {
        this.mContent = list;
    }

    public boolean cJM() {
        return this.juo;
    }

    public void rd(boolean z) {
        this.juo = z;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jun;
    }
}
