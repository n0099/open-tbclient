package com.baidu.tieba.frs.forumRule.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class c implements n {
    public static BdUniqueId jxk = BdUniqueId.gen();
    private boolean jxl;
    private List<PbContent> mContent;
    private String mTitle;

    public void a(ForumRule forumRule) {
        if (forumRule != null) {
            this.mTitle = forumRule.title;
            this.mContent = forumRule.content;
            this.jxl = forumRule.status.intValue() == 1;
        }
    }

    public String cHt() {
        return this.mTitle;
    }

    public void KJ(String str) {
        this.mTitle = str;
    }

    public List<PbContent> cHu() {
        return this.mContent;
    }

    public void dq(List<PbContent> list) {
        this.mContent = list;
    }

    public boolean cHv() {
        return this.jxl;
    }

    public void rj(boolean z) {
        this.jxl = z;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jxk;
    }
}
