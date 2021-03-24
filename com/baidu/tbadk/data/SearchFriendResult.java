package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchFriendResult extends OrmObject implements Serializable {
    public static final long serialVersionUID = 14010660746769448L;
    public String errmsg;
    public int errorno;
    public List<UserInfo> user_info;
    public String usermsg;

    /* loaded from: classes3.dex */
    public static class UserInfo extends OrmObject implements Serializable {
        public static final long serialVersionUID = -4475845825063348182L;
        public String portrait;
        public long user_id;
        public String user_name;

        public String getPortrait() {
            return this.portrait;
        }

        public long getUserId() {
            return this.user_id;
        }

        public String getUserName() {
            return this.user_name;
        }

        public void setPortrait(String str) {
            this.portrait = str;
        }

        public void setUserId(long j) {
            this.user_id = j;
        }

        public void setUserName(String str) {
            this.user_name = str;
        }
    }

    public String getErrMsg() {
        return this.errmsg;
    }

    public int getErrorNo() {
        return this.errorno;
    }

    public List<UserInfo> getUserInfo() {
        if (this.user_info == null) {
            this.user_info = new ArrayList();
        }
        return this.user_info;
    }

    public String getUserMsg() {
        return this.usermsg;
    }

    public void setErrMsg(String str) {
        this.errmsg = str;
    }

    public void setErrorNo(int i) {
        this.errorno = i;
    }

    public void setUserInfo(List<UserInfo> list) {
        this.user_info = list;
    }

    public void setUserMsg(String str) {
        this.usermsg = str;
    }
}
