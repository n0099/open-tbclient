package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.data.l;
/* loaded from: classes22.dex */
public class e implements q {
    public String aIk;
    public String jxa;
    public boolean jxb;
    public a[] jxc = new a[3];

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return l.iby;
    }

    public String cIY() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.jxc) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes22.dex */
    public static class a implements q {
        private long forumId;
        private String inb;
        private String jak;
        private long jde;
        private String jxd;
        private int jxe;
        private int jxf;
        private boolean jxg;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.q
        public BdUniqueId getType() {
            return l.iby;
        }

        public String cIZ() {
            return this.jak;
        }

        public a LE(String str) {
            this.jak = str;
            return this;
        }

        public String cJa() {
            return this.jxd;
        }

        public a LF(String str) {
            this.jxd = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a LG(String str) {
            this.slogan = str;
            return this;
        }

        public String cJb() {
            return this.inb;
        }

        public a LH(String str) {
            this.inb = str;
            return this;
        }

        public int cJc() {
            return this.jxe;
        }

        public a Bm(int i) {
            this.jxe = i;
            return this;
        }

        public int cJd() {
            return this.jxf;
        }

        public a Bn(int i) {
            this.jxf = i;
            return this;
        }

        public boolean cJe() {
            return this.jxg;
        }

        public a qP(boolean z) {
            this.jxg = z;
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

        public long crk() {
            return this.jde;
        }

        public a fQ(long j) {
            this.jde = j;
            return this;
        }
    }
}
