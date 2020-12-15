package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.data.k;
/* loaded from: classes22.dex */
public class d implements q {
    public String aJj;
    public String jLv;
    public boolean jLw;
    public a[] jLx = new a[3];

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return k.ino;
    }

    public String cNT() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.jLx) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes22.dex */
    public static class a implements q {
        private long forumId;
        private String iyK;
        private int jLA;
        private boolean jLB;
        private String jLy;
        private int jLz;
        private String joy;
        private long jrw;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.q
        public BdUniqueId getType() {
            return k.ino;
        }

        public String cNU() {
            return this.joy;
        }

        public a Mm(String str) {
            this.joy = str;
            return this;
        }

        public String cNV() {
            return this.jLy;
        }

        public a Mn(String str) {
            this.jLy = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a Mo(String str) {
            this.slogan = str;
            return this;
        }

        public String cNW() {
            return this.iyK;
        }

        public a Mp(String str) {
            this.iyK = str;
            return this;
        }

        public int cNX() {
            return this.jLz;
        }

        public a Cz(int i) {
            this.jLz = i;
            return this;
        }

        public int cNY() {
            return this.jLA;
        }

        public a CA(int i) {
            this.jLA = i;
            return this;
        }

        public boolean cNZ() {
            return this.jLB;
        }

        public a rt(boolean z) {
            this.jLB = z;
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

        public long cvc() {
            return this.jrw;
        }

        public a gy(long j) {
            this.jrw = j;
            return this;
        }
    }
}
