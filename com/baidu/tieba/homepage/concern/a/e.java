package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.data.l;
/* loaded from: classes21.dex */
public class e implements q {
    public String aEb;
    public String iPL;
    public boolean iPM;
    public a[] iPN = new a[3];

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return l.huj;
    }

    public String czM() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.iPN) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes21.dex */
    public static class a implements q {
        private long forumId;
        private String hFI;
        private String iPO;
        private int iPP;
        private int iPQ;
        private boolean iPR;
        private String isY;
        private long ivS;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.q
        public BdUniqueId getType() {
            return l.huj;
        }

        public String czN() {
            return this.isY;
        }

        public a Ka(String str) {
            this.isY = str;
            return this;
        }

        public String czO() {
            return this.iPO;
        }

        public a Kb(String str) {
            this.iPO = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a Kc(String str) {
            this.slogan = str;
            return this;
        }

        public String czP() {
            return this.hFI;
        }

        public a Kd(String str) {
            this.hFI = str;
            return this;
        }

        public int czQ() {
            return this.iPP;
        }

        public a Aa(int i) {
            this.iPP = i;
            return this;
        }

        public int czR() {
            return this.iPQ;
        }

        public a Ab(int i) {
            this.iPQ = i;
            return this;
        }

        public boolean czS() {
            return this.iPR;
        }

        public a pI(boolean z) {
            this.iPR = z;
            return this;
        }

        public long getForumId() {
            return this.forumId;
        }

        public a e(Long l) {
            if (l == null) {
                this.forumId = 0L;
            } else {
                this.forumId = l.longValue();
            }
            return this;
        }

        public long cig() {
            return this.ivS;
        }

        public a fb(long j) {
            this.ivS = j;
            return this;
        }
    }
}
