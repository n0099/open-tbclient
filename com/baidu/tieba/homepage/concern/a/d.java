package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.data.k;
/* loaded from: classes21.dex */
public class d implements q {
    public String aGz;
    public String jxR;
    public boolean jxS;
    public a[] jxT = new a[3];

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return k.icp;
    }

    public String cID() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.jxT) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes21.dex */
    public static class a implements q {
        private long forumId;
        private String inQ;
        private String jaW;
        private long jdR;
        private String jxU;
        private int jxV;
        private int jxW;
        private boolean jxX;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.q
        public BdUniqueId getType() {
            return k.icp;
        }

        public String cIE() {
            return this.jaW;
        }

        public a Lf(String str) {
            this.jaW = str;
            return this;
        }

        public String cIF() {
            return this.jxU;
        }

        public a Lg(String str) {
            this.jxU = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a Lh(String str) {
            this.slogan = str;
            return this;
        }

        public String cIG() {
            return this.inQ;
        }

        public a Li(String str) {
            this.inQ = str;
            return this;
        }

        public int cIH() {
            return this.jxV;
        }

        public a BK(int i) {
            this.jxV = i;
            return this;
        }

        public int cII() {
            return this.jxW;
        }

        public a BL(int i) {
            this.jxW = i;
            return this;
        }

        public boolean cIJ() {
            return this.jxX;
        }

        public a qS(boolean z) {
            this.jxX = z;
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

        public long cqN() {
            return this.jdR;
        }

        public a fT(long j) {
            this.jdR = j;
            return this;
        }
    }
}
