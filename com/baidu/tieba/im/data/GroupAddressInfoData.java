package com.baidu.tieba.im.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class GroupAddressInfoData implements Serializable {
    private static final long serialVersionUID = 5616188082014345808L;
    private List<String> addressList = new ArrayList();

    public void addAddress(String str) {
        if (str != null && !str.equals("") && !this.addressList.contains(str)) {
            this.addressList.add(str);
        }
    }

    public void removeAddress(String str) {
        this.addressList.remove(str);
    }

    public List<String> getAddressList() {
        return this.addressList;
    }
}
