package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.data.l;
/* loaded from: classes22.dex */
public class e implements q {
    public String aHf;
    public String jeF;
    public boolean jeG;
    public a[] jeH = new a[3];

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return l.hJe;
    }

    public String cDq() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.jeH) {
            sb.append(aVar.getForumId()).append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /* loaded from: classes22.dex */
    public static class a implements q {
        private long forumId;
        private String hUD;
        private String iHR;
        private long iKL;
        private String jeI;
        private int jeJ;
        private int jeK;
        private boolean jeL;
        private String slogan;

        @Override // com.baidu.adp.widget.ListView.q
        public BdUniqueId getType() {
            return l.hJe;
        }

        public String cDr() {
            return this.iHR;
        }

        public a KP(String str) {
            this.iHR = str;
            return this;
        }

        public String cDs() {
            return this.jeI;
        }

        public a KQ(String str) {
            this.jeI = str;
            return this;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public a KR(String str) {
            this.slogan = str;
            return this;
        }

        public String cDt() {
            return this.hUD;
        }

        public a KS(String str) {
            this.hUD = str;
            return this;
        }

        public int cDu() {
            return this.jeJ;
        }

        public a AG(int i) {
            this.jeJ = i;
            return this;
        }

        public int cDv() {
            return this.jeK;
        }

        public a AH(int i) {
            this.jeK = i;
            return this;
        }

        public boolean cDw() {
            return this.jeL;
        }

        public a qo(boolean z) {
            this.jeL = z;
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

        public long clC() {
            return this.iKL;
        }

        public a ft(long j) {
            this.iKL = j;
            return this;
        }
    }
}
