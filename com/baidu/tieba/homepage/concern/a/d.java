package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.data.k;
/* loaded from: classes22.dex */
public class d implements q {
    public String aJj;
    public String jLt;
    public boolean jLu;
    public a[] jLv = new a[3];

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return k.inm;
    }

    public String cNS() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.jLv) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes22.dex */
    public static class a implements q {
        private long forumId;
        private String iyI;
        private String jLw;
        private int jLx;
        private int jLy;
        private boolean jLz;
        private String jow;
        private long jru;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.q
        public BdUniqueId getType() {
            return k.inm;
        }

        public String cNT() {
            return this.jow;
        }

        public a Mm(String str) {
            this.jow = str;
            return this;
        }

        public String cNU() {
            return this.jLw;
        }

        public a Mn(String str) {
            this.jLw = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a Mo(String str) {
            this.slogan = str;
            return this;
        }

        public String cNV() {
            return this.iyI;
        }

        public a Mp(String str) {
            this.iyI = str;
            return this;
        }

        public int cNW() {
            return this.jLx;
        }

        public a Cz(int i) {
            this.jLx = i;
            return this;
        }

        public int cNX() {
            return this.jLy;
        }

        public a CA(int i) {
            this.jLy = i;
            return this;
        }

        public boolean cNY() {
            return this.jLz;
        }

        public a rt(boolean z) {
            this.jLz = z;
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

        public long cvb() {
            return this.jru;
        }

        public a gy(long j) {
            this.jru = j;
            return this;
        }
    }
}
