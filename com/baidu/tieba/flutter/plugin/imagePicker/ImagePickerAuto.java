package com.baidu.tieba.flutter.plugin.imagePicker;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class ImagePickerAuto {

    /* loaded from: classes4.dex */
    public interface HostImagePicker {
        void chosePhotoLibrary(HostParam hostParam);

        void editUserPortrait();

        void savePhoto(HostParam hostParam);

        void takePhoto(HostParam hostParam);
    }

    /* loaded from: classes4.dex */
    public static class HostParam {
        public String avatar;
        public String barId;
        public Boolean onlyNeedImageUrl;

        public static HostParam fromMap(HashMap hashMap) {
            HostParam hostParam = new HostParam();
            hostParam.barId = (String) hashMap.get("barId");
            hostParam.avatar = (String) hashMap.get("avatar");
            hostParam.onlyNeedImageUrl = (Boolean) hashMap.get("onlyNeedImageUrl");
            return hostParam;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public String getBarId() {
            return this.barId;
        }

        public Boolean getOnlyNeedImageUrl() {
            return this.onlyNeedImageUrl;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setBarId(String str) {
            this.barId = str;
        }

        public void setOnlyNeedImageUrl(Boolean bool) {
            this.onlyNeedImageUrl = bool;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("barId", this.barId);
            hashMap.put("avatar", this.avatar);
            hashMap.put("onlyNeedImageUrl", this.onlyNeedImageUrl);
            return hashMap;
        }
    }

    public static HashMap wrapError(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put("code", exc.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}
