package com.baidu.tieba.im.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ResponseRequestGroupLocMessage extends ResponsedMessage {
    private static final long serialVersionUID = 5780256009602114915L;
    private List<String> businessAreaList;
    private String position;

    public ResponseRequestGroupLocMessage() {
        this.position = "";
        this.businessAreaList = new ArrayList();
    }

    public ResponseRequestGroupLocMessage(int i) {
        super(i);
        this.position = "";
        this.businessAreaList = new ArrayList();
    }

    public void setPosition(String str) {
        if (str != null) {
            this.position = str;
        }
    }

    public String getPosition() {
        return this.position;
    }

    public void addBusinessArea(String str) {
        if (str != null && !str.equals("") && !this.businessAreaList.contains(str)) {
            this.businessAreaList.add(str);
        }
    }

    public Iterator<String> getIteraotrOfBusinessAreaList() {
        return this.businessAreaList.iterator();
    }
}
