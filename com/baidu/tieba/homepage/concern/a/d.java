package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.card.data.k;
/* loaded from: classes2.dex */
public class d implements n {
    public String aEU;
    public String jUe;
    public boolean jUf;
    public a[] jUg = new a[3];

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return k.ivc;
    }

    public String cNi() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.jUg) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a implements n {
        private long forumId;
        private String iGq;
        private String jUh;
        private int jUi;
        private int jUj;
        private boolean jUk;
        private String jwp;
        private long jzm;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.n
        public BdUniqueId getType() {
            return k.ivc;
        }

        public String cNj() {
            return this.jwp;
        }

        public a Le(String str) {
            this.jwp = str;
            return this;
        }

        public String cNk() {
            return this.jUh;
        }

        public a Lf(String str) {
            this.jUh = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a Lg(String str) {
            this.slogan = str;
            return this;
        }

        public String cNl() {
            return this.iGq;
        }

        public a Lh(String str) {
            this.iGq = str;
            return this;
        }

        public int cNm() {
            return this.jUi;
        }

        public a Bg(int i) {
            this.jUi = i;
            return this;
        }

        public int cNn() {
            return this.jUj;
        }

        public a Bh(int i) {
            this.jUj = i;
            return this;
        }

        public boolean cNo() {
            return this.jUk;
        }

        public a rM(boolean z) {
            this.jUk = z;
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

        public long cue() {
            return this.jzm;
        }

        public a gy(long j) {
            this.jzm = j;
            return this;
        }
    }
}
