package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.card.data.k;
/* loaded from: classes2.dex */
public class d implements n {
    public String aJH;
    public String jYJ;
    public boolean jYK;
    public a[] jYL = new a[3];

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return k.izJ;
    }

    public String cRa() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.jYL) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a implements n {
        private long forumId;
        private String iKX;
        private String jAV;
        private long jDS;
        private String jYM;
        private int jYN;
        private int jYO;
        private boolean jYP;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.n
        public BdUniqueId getType() {
            return k.izJ;
        }

        public String cRb() {
            return this.jAV;
        }

        public a Ml(String str) {
            this.jAV = str;
            return this;
        }

        public String cRc() {
            return this.jYM;
        }

        public a Mm(String str) {
            this.jYM = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a Mn(String str) {
            this.slogan = str;
            return this;
        }

        public String cRd() {
            return this.iKX;
        }

        public a Mo(String str) {
            this.iKX = str;
            return this;
        }

        public int cRe() {
            return this.jYN;
        }

        public a CN(int i) {
            this.jYN = i;
            return this;
        }

        public int cRf() {
            return this.jYO;
        }

        public a CO(int i) {
            this.jYO = i;
            return this;
        }

        public boolean cRg() {
            return this.jYP;
        }

        public a rQ(boolean z) {
            this.jYP = z;
            return this;
        }

        public long getForumId() {
            return this.forumId;
        }

        public a g(Long l) {
            if (l == null) {
                this.forumId = 0L;
            } else {
                this.forumId = l.longValue();
            }
            return this;
        }

        public long cxW() {
            return this.jDS;
        }

        public a gy(long j) {
            this.jDS = j;
            return this;
        }
    }
}
