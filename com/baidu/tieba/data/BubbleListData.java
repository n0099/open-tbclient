package com.baidu.tieba.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BubbleListData implements Serializable, Cloneable {
    private static final long serialVersionUID = -4612117445868668894L;
    private List<BubbleData> b_info = new ArrayList();
    private String error_code;
    private String error_msg;

    public String getError_code() {
        return this.error_code;
    }

    public void setError_code(String str) {
        this.error_code = str;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public List<BubbleData> getB_info() {
        return this.b_info;
    }

    public void setB_info(List<BubbleData> list) {
        this.b_info = list;
    }

    /* loaded from: classes.dex */
    public class BubbleData implements Serializable {
        private static final long serialVersionUID = 1540726255641451917L;
        private String b_url;
        private int bcode;
        private String bname;
        private int can_use;
        private String icon_url;
        private int is_def;
        private int is_free;

        public int getBcode() {
            return this.bcode;
        }

        public void setBcode(int i) {
            this.bcode = i;
        }

        public String getB_url() {
            return this.b_url;
        }

        public void setB_url(String str) {
            this.b_url = str;
        }

        public String getIcon_url() {
            return this.icon_url;
        }

        public void setIcon_url(String str) {
            this.icon_url = str;
        }

        public int getCan_use() {
            return this.can_use;
        }

        public void setCan_use(int i) {
            this.can_use = i;
        }

        public int getIs_def() {
            return this.is_def;
        }

        public void setIs_def(int i) {
            this.is_def = i;
        }

        public int getIs_free() {
            return this.is_free;
        }

        public void setIs_free(int i) {
            this.is_free = i;
        }

        public boolean canUse() {
            return this.can_use == 1;
        }

        public boolean isDef() {
            return this.is_def == 1;
        }

        public boolean isFree() {
            return this.is_free == 1;
        }

        public String getBname() {
            return this.bname;
        }

        public void setBname(String str) {
            this.bname = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BubbleListData m250clone() {
        try {
            Object clone = super.clone();
            if (clone instanceof BubbleListData) {
                return (BubbleListData) clone;
            }
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            return this;
        }
    }
}
