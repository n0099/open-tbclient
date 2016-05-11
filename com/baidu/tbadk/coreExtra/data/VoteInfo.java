package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VoteInfo implements Serializable {
    private static final long serialVersionUID = -3019177320586555309L;
    private String mDescription;
    private int mEndtime;
    private int mIsMulti;
    private int mMultiNum;
    private ArrayList<VoteOption> mOptions;
    private int mType;

    public int getMultiNum() {
        return this.mMultiNum;
    }

    public void setMultiNum(int i) {
        this.mMultiNum = i;
    }

    public int getIsMulti() {
        return this.mIsMulti;
    }

    public void setIsMulti(int i) {
        this.mIsMulti = i;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getEndtime() {
        return this.mEndtime;
    }

    public void setEndtime(int i) {
        this.mEndtime = i;
    }

    public ArrayList<VoteOption> getOptions() {
        return this.mOptions;
    }

    public void setOptions(ArrayList<VoteOption> arrayList) {
        this.mOptions = arrayList;
    }

    public void setServerImageCode(List<ImageFileInfo> list) {
        if (list != null && this.mOptions != null && this.mOptions.size() == list.size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    this.mOptions.get(i2).serverCode = list.get(i2).getServerImageCode();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public String buildWriteContent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_multi", this.mIsMulti);
            jSONObject.put("description", this.mDescription);
            jSONObject.put("type", this.mType);
            jSONObject.put(ThActivityDetailActivityConfig.END_TIME, this.mEndtime);
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mOptions.size()) {
                    VoteOption voteOption = this.mOptions.get(i2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("text", voteOption.text);
                    jSONObject2.put(TbConfig.TMP_PIC_DIR_NAME, voteOption.serverCode);
                    jSONArray.put(i2, jSONObject2);
                    i = i2 + 1;
                } else {
                    jSONObject.put("options", jSONArray);
                    return jSONObject.toString();
                }
            }
        } catch (JSONException e) {
            return "";
        }
    }

    /* loaded from: classes.dex */
    public static class VoteOption implements Serializable {
        private static final long serialVersionUID = 5062245992752466358L;
        public int id;
        public ImageFileInfo imageFileInfo;
        public String serverCode;
        public String text;

        public VoteOption(int i, String str, ImageFileInfo imageFileInfo) {
            this.id = i;
            this.text = str;
            this.imageFileInfo = imageFileInfo;
        }
    }
}
