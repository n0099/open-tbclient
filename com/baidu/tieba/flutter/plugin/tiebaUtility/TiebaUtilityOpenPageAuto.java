package com.baidu.tieba.flutter.plugin.tiebaUtility;

import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaUtilityOpenPageAuto {

    /* loaded from: classes4.dex */
    public interface HostUtilityOpenPage {
        void accessLiveCenterService(PageStringValue pageStringValue);

        void accessWalletService(PageStringValue pageStringValue);

        void goToActivityCenter();

        void goToGameCenter();

        void goToMainTabRefresh(ToWhereParam toWhereParam);

        void goToSearch(SearchParam searchParam);

        void goToSendThread(SendThreadParam sendThreadParam);

        void goToSignIn(SignInParam signInParam);

        void goToTeenagerMode();

        void openAppStore(PageStringValue pageStringValue, Result<OpenPageBoolResult> result);

        void openBBASMAppForItem(SMAppMapParam sMAppMapParam);

        void openBBASMAppForUrl(PageStringValue pageStringValue);

        void postSignProcess(SignProcessParam signProcessParam);

        void redirectTo(PageStringValue pageStringValue);

        void shareFrs(PageStringValue pageStringValue);
    }

    /* loaded from: classes4.dex */
    public static class OpenPageBoolResult {
        public Boolean result;

        public static OpenPageBoolResult fromMap(HashMap hashMap) {
            OpenPageBoolResult openPageBoolResult = new OpenPageBoolResult();
            openPageBoolResult.result = (Boolean) hashMap.get("result");
            return openPageBoolResult;
        }

        public Boolean getResult() {
            return this.result;
        }

        public void setResult(Boolean bool) {
            this.result = bool;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class PageStringValue {
        public String result;

        public static PageStringValue fromMap(HashMap hashMap) {
            PageStringValue pageStringValue = new PageStringValue();
            pageStringValue.result = (String) hashMap.get("result");
            return pageStringValue;
        }

        public String getResult() {
            return this.result;
        }

        public void setResult(String str) {
            this.result = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* loaded from: classes4.dex */
    public static class SMAppMapParam {
        public HashMap result;

        public static SMAppMapParam fromMap(HashMap hashMap) {
            SMAppMapParam sMAppMapParam = new SMAppMapParam();
            sMAppMapParam.result = (HashMap) hashMap.get("result");
            return sMAppMapParam;
        }

        public HashMap getResult() {
            return this.result;
        }

        public void setResult(HashMap hashMap) {
            this.result = hashMap;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class SearchParam {
        public String search;
        public String searchValue;

        public static SearchParam fromMap(HashMap hashMap) {
            SearchParam searchParam = new SearchParam();
            searchParam.search = (String) hashMap.get("search");
            searchParam.searchValue = (String) hashMap.get(SquareSearchActivityConfig.SEARCH_VALUE);
            return searchParam;
        }

        public String getSearch() {
            return this.search;
        }

        public String getSearchValue() {
            return this.searchValue;
        }

        public void setSearch(String str) {
            this.search = str;
        }

        public void setSearchValue(String str) {
            this.searchValue = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("search", this.search);
            hashMap.put(SquareSearchActivityConfig.SEARCH_VALUE, this.searchValue);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class SendThreadParam {
        public Double dx;
        public Double dy;
        public Double height;
        public Double width;

        public static SendThreadParam fromMap(HashMap hashMap) {
            SendThreadParam sendThreadParam = new SendThreadParam();
            sendThreadParam.dx = (Double) hashMap.get("dx");
            sendThreadParam.dy = (Double) hashMap.get("dy");
            sendThreadParam.width = (Double) hashMap.get("width");
            sendThreadParam.height = (Double) hashMap.get("height");
            return sendThreadParam;
        }

        public Double getDx() {
            return this.dx;
        }

        public Double getDy() {
            return this.dy;
        }

        public Double getHeight() {
            return this.height;
        }

        public Double getWidth() {
            return this.width;
        }

        public void setDx(Double d2) {
            this.dx = d2;
        }

        public void setDy(Double d2) {
            this.dy = d2;
        }

        public void setHeight(Double d2) {
            this.height = d2;
        }

        public void setWidth(Double d2) {
            this.width = d2;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", this.dx);
            hashMap.put("dy", this.dy);
            hashMap.put("width", this.width);
            hashMap.put("height", this.height);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class SignInParam {
        public String msignText;
        public String msignValid;

        public static SignInParam fromMap(HashMap hashMap) {
            SignInParam signInParam = new SignInParam();
            signInParam.msignValid = (String) hashMap.get("msignValid");
            signInParam.msignText = (String) hashMap.get("msignText");
            return signInParam;
        }

        public String getMsignText() {
            return this.msignText;
        }

        public String getMsignValid() {
            return this.msignValid;
        }

        public void setMsignText(String str) {
            this.msignText = str;
        }

        public void setMsignValid(String str) {
            this.msignValid = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("msignValid", this.msignValid);
            hashMap.put("msignText", this.msignText);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class SignProcessParam {
        public String bannerHyperLink;
        public String bannerImageUrl;
        public Boolean isVipMember;

        public static SignProcessParam fromMap(HashMap hashMap) {
            SignProcessParam signProcessParam = new SignProcessParam();
            signProcessParam.bannerImageUrl = (String) hashMap.get("bannerImageUrl");
            signProcessParam.bannerHyperLink = (String) hashMap.get("bannerHyperLink");
            signProcessParam.isVipMember = (Boolean) hashMap.get("isVipMember");
            return signProcessParam;
        }

        public String getBannerHyperLink() {
            return this.bannerHyperLink;
        }

        public String getBannerImageUrl() {
            return this.bannerImageUrl;
        }

        public Boolean getIsVipMember() {
            return this.isVipMember;
        }

        public void setBannerHyperLink(String str) {
            this.bannerHyperLink = str;
        }

        public void setBannerImageUrl(String str) {
            this.bannerImageUrl = str;
        }

        public void setIsVipMember(Boolean bool) {
            this.isVipMember = bool;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("bannerImageUrl", this.bannerImageUrl);
            hashMap.put("bannerHyperLink", this.bannerHyperLink);
            hashMap.put("isVipMember", this.isVipMember);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class ToWhereParam {
        public Long result;

        public static ToWhereParam fromMap(HashMap hashMap) {
            Long valueOf;
            ToWhereParam toWhereParam = new ToWhereParam();
            Object obj = hashMap.get("result");
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            toWhereParam.result = valueOf;
            return toWhereParam;
        }

        public Long getResult() {
            return this.result;
        }

        public void setResult(Long l) {
            this.result = l;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
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
