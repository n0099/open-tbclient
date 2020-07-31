package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class c extends l {
    private EditText eCh;

    public c(Context context) {
        super(context, (String) null, 29);
        this.eAT = false;
        this.eAS = 3;
        this.ezZ = new TopicDetaiInputContainer(context);
        this.eCh = ((TopicDetaiInputContainer) this.ezZ).getInputView();
        ((TopicDetaiInputContainer) this.ezZ).setHint(context.getString(R.string.say_your_point));
        this.eAU = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.eCh;
    }
}
