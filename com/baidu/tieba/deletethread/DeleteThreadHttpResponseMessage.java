package com.baidu.tieba.deletethread;

import android.text.TextUtils;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DeleteThreadHttpResponseMessage extends TbHttpResponsedMessage {
    private int blockFail;
    private int blockSuccess;
    private ArrayList<String> failItems;
    private int retType;
    private ArrayList<String> successItems;
    private String text;

    public DeleteThreadHttpResponseMessage() {
        super(CmdConfigHttp.CMD_NEG_DELETE_THREAD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        String parseToString = parseToString(bArr);
        if (!TextUtils.isEmpty(parseToString)) {
            JSONObject jSONObject = new JSONObject(parseToString);
            setError(jSONObject.optInt("error_code", -1));
            setErrorString(jSONObject.optString(AlaRecorderLog.KEY_ERROR_MSG));
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject != null) {
                this.blockSuccess = optJSONObject.optInt("block_success");
                this.blockFail = optJSONObject.optInt("block_fail");
                this.retType = optJSONObject.optInt("ret_type");
                this.text = optJSONObject.optString("text");
                JSONArray optJSONArray = optJSONObject.optJSONArray("del_fail");
                this.failItems = new ArrayList<>();
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        this.failItems.add(optJSONArray.optString(i2));
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("del_success");
                this.successItems = new ArrayList<>();
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        this.successItems.add(optJSONArray2.optString(i3));
                    }
                }
            }
        }
    }

    public ArrayList<String> getSuccessItems() {
        return this.successItems;
    }

    public ArrayList<String> getFailItems() {
        return this.failItems;
    }

    public int getBlockSuccess() {
        return this.blockSuccess;
    }

    public int getBlockFail() {
        return this.blockFail;
    }

    public int getRetType() {
        return this.retType;
    }

    public String getText() {
        return this.text;
    }
}
