package com.baidu.tieba.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SetBubbleResultData implements Serializable {
    private static final long serialVersionUID = -4612117445868668894L;
    private ResultInfo b_info = new ResultInfo();
    private String error_code;
    private String error_msg;

    public ResultInfo getB_info() {
        return this.b_info;
    }

    public void setB_info(ResultInfo resultInfo) {
        this.b_info = resultInfo;
    }

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

    /* loaded from: classes.dex */
    public class ResultInfo implements Serializable {
        private static final long serialVersionUID = 1818506758727291395L;
        private String b_url;
        private int can_use;
        private int is_free;
        private String t_msg;

        public int getCan_use() {
            return this.can_use;
        }

        public void setCan_use(int i) {
            this.can_use = i;
        }

        public int getIs_free() {
            return this.is_free;
        }

        public void setIs_free(int i) {
            this.is_free = i;
        }

        public String getT_msg() {
            return this.t_msg;
        }

        public void setT_msg(String str) {
            this.t_msg = str;
        }

        public boolean canUser() {
            return this.can_use == 1;
        }

        public boolean isFree() {
            return this.is_free == 1;
        }

        public String getB_url() {
            return this.b_url;
        }

        public void setB_url(String str) {
            this.b_url = str;
        }
    }
}
