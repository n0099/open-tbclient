package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchFriendResult extends OrmObject implements Serializable {
    private static final long serialVersionUID = 14010660746769448L;
    private String errmsg;
    private int errorno;
    private List<UserInfo> user_info;
    private String usermsg;

    public void setErrorNo(int i) {
        this.errorno = i;
    }

    public int getErrorNo() {
        return this.errorno;
    }

    public void setErrMsg(String str) {
        this.errmsg = str;
    }

    public String getErrMsg() {
        return this.errmsg;
    }

    public void setUserMsg(String str) {
        this.usermsg = str;
    }

    public String getUserMsg() {
        return this.usermsg;
    }

    public void setUserInfo(List<UserInfo> list) {
        this.user_info = list;
    }

    public List<UserInfo> getUserInfo() {
        if (this.user_info == null) {
            this.user_info = new ArrayList();
        }
        return this.user_info;
    }

    /* loaded from: classes.dex */
    public static class UserInfo extends OrmObject implements Serializable {
        private static final long serialVersionUID = -4475845825063348182L;
        private String portrait;
        private long user_id;
        private String user_name;

        public void setUserId(long j) {
            this.user_id = j;
        }

        public long getUserId() {
            return this.user_id;
        }

        public void setUserName(String str) {
            this.user_name = str;
        }

        public String getUserName() {
            return this.user_name;
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public String getPortrait() {
            return this.portrait;
        }
    }
}
