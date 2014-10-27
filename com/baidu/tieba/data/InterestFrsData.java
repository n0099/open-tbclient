package com.baidu.tieba.data;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class InterestFrsData extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    private static final long serialVersionUID = 3148930531307087667L;
    private String errmsg;
    private int errno;
    private ArrayList<Tag> tag_list = new ArrayList<>();
    private String usermsg;

    public int getErrno() {
        return this.errno;
    }

    public void setErrno(int i) {
        this.errno = i;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String str) {
        this.errmsg = str;
    }

    public String getUsermsg() {
        return this.usermsg;
    }

    public ArrayList<Tag> getTag_list() {
        return this.tag_list;
    }

    /* loaded from: classes.dex */
    public class Tag extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        private static final long serialVersionUID = -161320459489433271L;
        private String bdesc;
        private String bgpic;
        private String bicon;
        private int bid;
        private String bname;
        private int btype;
        private ArrayList<Card> card_list = new ArrayList<>();

        public int getBid() {
            return this.bid;
        }

        public String getBname() {
            return this.bname;
        }

        public String getBicon() {
            return this.bicon;
        }

        public String getBgpic() {
            return this.bgpic;
        }

        public int getBtype() {
            return this.btype;
        }

        public String getBdesc() {
            return this.bdesc;
        }

        public ArrayList<Card> getCard_list() {
            return this.card_list;
        }
    }

    /* loaded from: classes.dex */
    public class Card extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        private static final long serialVersionUID = -6381883030119073721L;
        private String avatar;
        private String cdesc;
        private int cid;
        private int fid;
        private String fname;
        private String icon_url;
        private int is_like;
        private int order;
        private String slogan;

        public int getOrder() {
            return this.order;
        }

        public int getCid() {
            return this.cid;
        }

        public String getFname() {
            return this.fname;
        }

        public int getFid() {
            return this.fid;
        }

        public String getCdesc() {
            return this.cdesc;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public String getIcon_url() {
            return this.icon_url;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public int getIs_like() {
            return this.is_like;
        }

        public void setIs_like(int i) {
            this.is_like = i;
        }
    }
}
