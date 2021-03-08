package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.card.data.k;
/* loaded from: classes2.dex */
public class d implements n {
    public String aIQ;
    public String kdV;
    public boolean kdW;
    public a[] kdX = new a[3];

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return k.iCJ;
    }

    public String cPs() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.kdX) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a implements n {
        private long forumId;
        private String iNW;
        private String jDS;
        private long jGO;
        private String kdY;
        private int kdZ;
        private int kea;
        private boolean keb;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.n
        public BdUniqueId getType() {
            return k.iCJ;
        }

        public String cPt() {
            return this.jDS;
        }

        public a LW(String str) {
            this.jDS = str;
            return this;
        }

        public String cPu() {
            return this.kdY;
        }

        public a LX(String str) {
            this.kdY = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a LY(String str) {
            this.slogan = str;
            return this;
        }

        public String cPv() {
            return this.iNW;
        }

        public a LZ(String str) {
            this.iNW = str;
            return this;
        }

        public int cPw() {
            return this.kdZ;
        }

        public a Bz(int i) {
            this.kdZ = i;
            return this;
        }

        public int cPx() {
            return this.kea;
        }

        public a BA(int i) {
            this.kea = i;
            return this;
        }

        public boolean cPy() {
            return this.keb;
        }

        public a rY(boolean z) {
            this.keb = z;
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

        public long cvD() {
            return this.jGO;
        }

        public a gD(long j) {
            this.jGO = j;
            return this;
        }
    }
}
