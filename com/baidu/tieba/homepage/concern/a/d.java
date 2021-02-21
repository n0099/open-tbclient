package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.card.data.k;
/* loaded from: classes2.dex */
public class d implements n {
    public String aHq;
    public String kbT;
    public boolean kbU;
    public a[] kbV = new a[3];

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return k.iBa;
    }

    public String cPl() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.kbV) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a implements n {
        private long forumId;
        private String iMn;
        private String jCj;
        private long jFf;
        private String kbW;
        private int kbX;
        private int kbY;
        private boolean kbZ;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.n
        public BdUniqueId getType() {
            return k.iBa;
        }

        public String cPm() {
            return this.jCj;
        }

        public a LQ(String str) {
            this.jCj = str;
            return this;
        }

        public String cPn() {
            return this.kbW;
        }

        public a LR(String str) {
            this.kbW = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a LS(String str) {
            this.slogan = str;
            return this;
        }

        public String cPo() {
            return this.iMn;
        }

        public a LT(String str) {
            this.iMn = str;
            return this;
        }

        public int cPp() {
            return this.kbX;
        }

        public a Bw(int i) {
            this.kbX = i;
            return this;
        }

        public int cPq() {
            return this.kbY;
        }

        public a Bx(int i) {
            this.kbY = i;
            return this;
        }

        public boolean cPr() {
            return this.kbZ;
        }

        public a rY(boolean z) {
            this.kbZ = z;
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

        public long cvx() {
            return this.jFf;
        }

        public a gD(long j) {
            this.jFf = j;
            return this;
        }
    }
}
