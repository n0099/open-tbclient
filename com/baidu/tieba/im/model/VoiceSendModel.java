package com.baidu.tieba.im.model;

import android.content.Context;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class VoiceSendModel extends e {
    private UploadTask mUploadTask;
    private UploadVoiceCallback mUploadVoiceCallback;

    /* loaded from: classes.dex */
    public interface UploadVoiceCallback {
        void callback(String str, ChatMessage chatMessage);
    }

    public VoiceSendModel(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void cancel() {
        if (this.mUploadTask != null) {
            this.mUploadTask.cancel();
            this.mUploadTask = null;
        }
    }

    public void upload(String str, ChatMessage chatMessage) {
        this.mUploadTask = new UploadTask(str, chatMessage);
        this.mUploadTask.execute(new Object[0]);
    }

    public void setUploadVoiceCallback(UploadVoiceCallback uploadVoiceCallback) {
        this.mUploadVoiceCallback = uploadVoiceCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class UploadTask extends BdAsyncTask<Object, Integer, String> {
        private HttpUploadService http = new HttpUploadService();
        private ChatMessage mChatMessage;
        private String mVid;

        public UploadTask(String str, ChatMessage chatMessage) {
            this.mVid = str;
            this.mChatMessage = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            try {
                return this.http.submitVoiceBinary(this.mVid);
            } catch (Exception e) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((UploadTask) str);
            if (VoiceSendModel.this.mUploadVoiceCallback != null) {
                VoiceSendModel.this.mUploadVoiceCallback.callback(str, this.mChatMessage);
            }
        }
    }
}
