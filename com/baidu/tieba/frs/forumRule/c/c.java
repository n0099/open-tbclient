package com.baidu.tieba.frs.forumRule.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes22.dex */
public class c implements q {
    public static BdUniqueId jhL = BdUniqueId.gen();
    private boolean jhM;
    private List<PbContent> mContent;
    private String mTitle;

    public void a(ForumRule forumRule) {
        if (forumRule != null) {
            this.mTitle = forumRule.title;
            this.mContent = forumRule.content;
            this.jhM = forumRule.status.intValue() == 1;
        }
    }

    public String cGK() {
        return this.mTitle;
    }

    public void KZ(String str) {
        this.mTitle = str;
    }

    public List<PbContent> cGL() {
        return this.mContent;
    }

    public void dn(List<PbContent> list) {
        this.mContent = list;
    }

    public boolean cGM() {
        return this.jhM;
    }

    public void qF(boolean z) {
        this.jhM = z;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jhL;
    }
}
