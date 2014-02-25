package com.baidu.tieba.data;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class InterestFrsData implements Serializable {
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

    public void setUsermsg(String str) {
        this.usermsg = str;
    }

    public ArrayList<Tag> getTag_list() {
        return this.tag_list;
    }

    public void setTag_list(ArrayList<Tag> arrayList) {
        this.tag_list = arrayList;
    }

    /* loaded from: classes.dex */
    public class Tag implements Serializable {
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

        public void setBid(int i) {
            this.bid = i;
        }

        public String getBname() {
            return this.bname;
        }

        public void setBname(String str) {
            this.bname = str;
        }

        public String getBicon() {
            return this.bicon;
        }

        public void setBicon(String str) {
            this.bicon = str;
        }

        public String getBgpic() {
            return this.bgpic;
        }

        public void setBgpic(String str) {
            this.bgpic = str;
        }

        public int getBtype() {
            return this.btype;
        }

        public void setBtype(int i) {
            this.btype = i;
        }

        public String getBdesc() {
            return this.bdesc;
        }

        public void setBdesc(String str) {
            this.bdesc = str;
        }

        public ArrayList<Card> getCard_list() {
            return this.card_list;
        }

        public void setCard_list(ArrayList<Card> arrayList) {
            this.card_list = arrayList;
        }
    }

    /* loaded from: classes.dex */
    public class Card implements Serializable {
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

        public void setOrder(int i) {
            this.order = i;
        }

        public int getCid() {
            return this.cid;
        }

        public void setCid(int i) {
            this.cid = i;
        }

        public String getFname() {
            return this.fname;
        }

        public void setFname(String str) {
            this.fname = str;
        }

        public int getFid() {
            return this.fid;
        }

        public void setFid(int i) {
            this.fid = i;
        }

        public String getCdesc() {
            return this.cdesc;
        }

        public void setCdesc(String str) {
            this.cdesc = str;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public void setSlogan(String str) {
            this.slogan = str;
        }

        public String getIcon_url() {
            return this.icon_url;
        }

        public void setIcon_url(String str) {
            this.icon_url = str;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public int getIs_like() {
            return this.is_like;
        }

        public void setIs_like(int i) {
            this.is_like = i;
        }
    }
}
