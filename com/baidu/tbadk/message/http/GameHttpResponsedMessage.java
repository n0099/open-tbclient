package com.baidu.tbadk.message.http;

import java.io.ByteArrayInputStream;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
/* loaded from: classes.dex */
public class GameHttpResponsedMessage extends TbHttpResponsedMessage {
    private static final String FULL_SCREEN_ATTR = "full-orientation";
    private static final String SCREEN_ORIENTATION_ATTR = "screen-orientation";
    private String mFullScreen;
    private String mScreenOrientation;

    public GameHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        Iterator<Element> it = Jsoup.parse(new ByteArrayInputStream(bArr), getCharset(), "").select("meta").iterator();
        while (it.hasNext()) {
            Element next = it.next();
            String attr = next.attr("name");
            String attr2 = next.attr("content");
            if (SCREEN_ORIENTATION_ATTR.equals(attr)) {
                this.mScreenOrientation = attr2;
            } else if (FULL_SCREEN_ATTR.equals(attr)) {
                this.mFullScreen = attr2;
            }
        }
    }

    public String getScreenOrientation() {
        return this.mScreenOrientation;
    }
}
