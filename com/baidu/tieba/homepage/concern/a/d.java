package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.card.data.k;
/* loaded from: classes2.dex */
public class d implements n {
    public String aHq;
    public String kbF;
    public boolean kbG;
    public a[] kbH = new a[3];

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return k.iAM;
    }

    public String cPe() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.kbH) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a implements n {
        private long forumId;
        private String iLZ;
        private String jBV;
        private long jER;
        private String kbI;
        private int kbJ;
        private int kbK;
        private boolean kbL;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.n
        public BdUniqueId getType() {
            return k.iAM;
        }

        public String cPf() {
            return this.jBV;
        }

        public a LP(String str) {
            this.jBV = str;
            return this;
        }

        public String cPg() {
            return this.kbI;
        }

        public a LQ(String str) {
            this.kbI = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a LR(String str) {
            this.slogan = str;
            return this;
        }

        public String cPh() {
            return this.iLZ;
        }

        public a LS(String str) {
            this.iLZ = str;
            return this;
        }

        public int cPi() {
            return this.kbJ;
        }

        public a Bw(int i) {
            this.kbJ = i;
            return this;
        }

        public int cPj() {
            return this.kbK;
        }

        public a Bx(int i) {
            this.kbK = i;
            return this;
        }

        public boolean cPk() {
            return this.kbL;
        }

        public a rY(boolean z) {
            this.kbL = z;
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

        public long cvq() {
            return this.jER;
        }

        public a gD(long j) {
            this.jER = j;
            return this;
        }
    }
}
