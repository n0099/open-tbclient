package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.data.l;
/* loaded from: classes22.dex */
public class e implements q {
    public String aHs;
    public String jrd;
    public boolean jre;
    public a[] jrf = new a[3];

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return l.hVB;
    }

    public String cGx() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.jrf) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes22.dex */
    public static class a implements q {
        private long forumId;
        private String iUn;
        private long iXh;
        private String ihd;
        private String jrg;
        private int jrh;
        private int jri;
        private boolean jrj;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.q
        public BdUniqueId getType() {
            return l.hVB;
        }

        public String cGy() {
            return this.iUn;
        }

        public a Ln(String str) {
            this.iUn = str;
            return this;
        }

        public String cGz() {
            return this.jrg;
        }

        public a Lo(String str) {
            this.jrg = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a Lp(String str) {
            this.slogan = str;
            return this;
        }

        public String cGA() {
            return this.ihd;
        }

        public a Lq(String str) {
            this.ihd = str;
            return this;
        }

        public int cGB() {
            return this.jrh;
        }

        public a AZ(int i) {
            this.jrh = i;
            return this;
        }

        public int cGC() {
            return this.jri;
        }

        public a Ba(int i) {
            this.jri = i;
            return this;
        }

        public boolean cGD() {
            return this.jrj;
        }

        public a qG(boolean z) {
            this.jrj = z;
            return this;
        }

        public long getForumId() {
            return this.forumId;
        }

        public a f(Long l) {
            if (l == null) {
                this.forumId = 0L;
            } else {
                this.forumId = l.longValue();
            }
            return this;
        }

        public long coJ() {
            return this.iXh;
        }

        public a fu(long j) {
            this.iXh = j;
            return this;
        }
    }
}
